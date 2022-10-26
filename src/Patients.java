public class Patients {
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
    private int UNOS_Status;
    private String dateOfBirth;

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
        this.UNOS_Status = setUNOS_Status(UNOS_Status);
        this.dateOfBirth = dateOfBirth;
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
    public String getDateOfBirth() {
        return dateOfBirth;
    }
    public int getUNOS_Status() {
        return UNOS_Status;
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
                // exit out loop
            }
        }
        return 1;
    }
}
