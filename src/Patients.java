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
    private String UNOS_Status;
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
        this.UNOS_Status = UNOS_Status;
        this.dateOfBirth = dateOfBirth;
    }
}
