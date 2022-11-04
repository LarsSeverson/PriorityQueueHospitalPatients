import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Patients {
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_RESET = "\u001B[0m";

    private final String firstName;
    private final String lastName;
    private final String address;
    private final String city;
    private final String county;
    private final String state;
    // could be int
    private final String zip;
    private final String phone1;
    private final String phone2;
    private final String email;
    private final String dateListed;
    private String fullDOB;
    private String fullUNOS;

    private int UNOS_Status;
    private final int dateOfBirth;

    private final HistoryQueue history;

    public Patients(String firstName, String lastName, String address,
                     String city, String county, String state, String zip,
                     String phone1, String phone2, String email,
                     String dateListed, String UNOS_Status, String dateOfBirth){
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.county = county;
        this.state = state;
        this.zip = zip;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.email = email;

        this.history = new HistoryQueue();
        this.dateListed = dateListed;
        this.fullUNOS = UNOS_Status;
        this.UNOS_Status = setUNOS(UNOS_Status);
        addRecord(this.dateListed, fullUNOS);

        this.fullDOB = dateOfBirth;
        this.dateOfBirth = setDateOfBirth(dateOfBirth);

    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getAddress() {
        return address;
    }
    public String getCity() {
        return city;
    }
    public String getCounty() {
        return county;
    }
    public String getState() {
        return state;
    }
    public String getZip() {
        return zip;
    }
    public String getPhone1() {
        return phone1;
    }
    public String getPhone2() {
        return phone2;
    }
    public String getEmail() {
        return email;
    }
    public String getDateListed() {
        return dateListed;
    }
    public String getFullDOB() {
        return fullDOB;
    }
    public String getFullUNOS() {
        return fullUNOS;
    }
    public int getDateOfBirth() {
        return dateOfBirth;
    }
    public int getUNOS_Status() {
        return UNOS_Status;
    }
    // In case we ever need to directly change the UNOS status for comparison (see removePatient())
    public void setUNOSbyInt(int UNOS_Status) {
        this.UNOS_Status = UNOS_Status;
    }
    public void setFullUNOS(String fullUNOS) {
        this.fullUNOS = fullUNOS;
    }
    public int setUNOS(String unos){
        switch (unos.toUpperCase()) {
            case "STATUS 1A" -> {
                setFullUNOS("Status 1A");
                return 4;
            }
            case "STATUS 1B" -> {
                setFullUNOS("Status 1B");
                return 3;
            }
            case "STATUS 2" -> {
                setFullUNOS("Status 2");
                return 2;
            }
            default -> {
                setFullUNOS("Status 7");
                return 1;
            }
        }
    }
    public void addRecord(String dateListed, String status){
        history.add(status, dateListed);
    }

    private int setDateOfBirth(String dateOfBirth){
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy");
        // more checks could be implemented like if the patientYear is an int
        if (dateOfBirth.length() < 4){
            return 1000;
        }
        int currentYear = Integer.parseInt(dateFormat.format(date).substring(dateFormat.format(date).length()-4));
        int patientYear = exact(new SimpleDateFormat("MMdd").format(date), dateOfBirth.replaceAll("/", ""));
        patientYear += Integer.parseInt(dateOfBirth.substring(dateOfBirth.length() - 4));

        return currentYear - patientYear;
    }
    private int exact(String monthDay, String DOB){
        int patient = Integer.parseInt(DOB.substring(DOB.length() - 5));
        int current = Integer.parseInt(monthDay);
        return patient < current ? 1 : 0;
    }
    @Override
    public String toString(){

        return
                        "\nPatient's first name: " + this.firstName +
                        "\nPatient's last name: " + this.lastName +
                        "\nDate of birth of the patient: " + this.fullDOB +
                        "\nAddress: " + this.address +
                        "\nCity: " + this.city +
                        "\nCounty: " + this.county +
                        "\nState: " + this.state +
                        "\nZip code: " + this.zip +
                        "\nPhone Number (1st Preference): " + this.phone1 +
                        "\nPhone Number (2nd Preference): " + this.phone2 +
                        "\nEmail address: " + this.email +
                        "\nUNOS Status: " + this.fullUNOS +
                            "\n" + this.history.toString();
    }

}
