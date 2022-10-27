import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Patients {
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_RESET = "\u001B[0m";

    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String county;
    private String state;
    // could be int
    private String zip;
    private String phone1;
    private String phone2;
    private String email;
    private String dateListed;
    private String fullDOB;
    private String fullUNOS;

    private int UNOS_Status;
    private int dateOfBirth;

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
        this.dateListed = dateListed;

        this.fullUNOS = UNOS_Status;
        this.UNOS_Status = setUNOS_Status(UNOS_Status);

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
    public void setUNOS_Status(int UNOS_Status) {
        this.UNOS_Status = UNOS_Status;
    }

    private int setUNOS_Status(String unos){
        switch(unos.toUpperCase()){
            case "STATUS 1A" -> {
                return 4;
            }
            case "STATUS 1B" ->{
                return 3;
            }
            case "STATUS 2" ->{
                return 2;
            }
            default -> {
                this.fullUNOS = "Status 7";
                // exit out loop
            }
        }
        return 1;
    }
    private int setDateOfBirth(String dateOfBirth){
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy");

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
                        "\nData listed on " + ANSI_RED + this.fullUNOS + ANSI_RESET +": "
                                + this.dateListed + "\n";
    }
}
