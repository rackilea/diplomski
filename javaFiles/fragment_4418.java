public class Contact extends SQL_Objects {

    private SimpleStringProperty id;
    private SimpleStringProperty firstName;
    private SimpleStringProperty lastName;
    private SimpleStringProperty phone;
    private SimpleStringProperty email;
    private SimpleStringProperty unitNo;
    private SimpleStringProperty street;
    private SimpleStringProperty city;
    private SimpleStringProperty province;
    private SimpleStringProperty zipCode;
    private SimpleStringProperty country;
    private SimpleStringProperty gender;
    private SimpleStringProperty notes;

    private SimpleStringProperty relationship;

    private final static String[] FIELD_NAMES = { "id", "firstName", "lastName", "phone", "email", "unitNo", "street", "city", "province", "zipCode", "country", "gender", "notes", "relationship" };

    public Contact(String id, String firstName, String lastName, String phone, String email, String unitNo, String street, String city, String province, String zipCode, String country, String gender, String notes, String relationship) {
        this.id = new SimpleStringProperty(id);
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.phone = new SimpleStringProperty(phone);
        this.email = new SimpleStringProperty(email);
        this.unitNo = new SimpleStringProperty(street);
        this.street = new SimpleStringProperty(street);
        this.city = new SimpleStringProperty(city);
        this.province = new SimpleStringProperty(province);
        this.zipCode = new SimpleStringProperty(zipCode);
        this.country = new SimpleStringProperty(country);
        this.gender = new SimpleStringProperty(gender);
        this.notes = new SimpleStringProperty(notes);
        this.relationship = new SimpleStringProperty(relationship);
    }

    public String getId() {
        return id.get();
    }

    public String getFirstName() {
        return firstName.get();
    }

    public String getLastName() {
        return lastName.get();
    }

    public String getPhone() {
        return phone.get();
    }

    public String getEmail() {
        return email.get();
    }

    public String getUnitNo() {
        return unitNo.get();
    }

    public String getStreet() {
        return street.get();
    }

    public String getCity() {
        return city.get();
    }

    public String getProvince() {
        return province.get();
    }

    public String getZipCode() {
        return zipCode.get();
    }

    public String getCountry() {
        return country.get();
    }

    public String getGender() {
        return gender.get();
    }

    public String getNotes() {
        return notes.get();
    }

    public String getRelationship() {
        return relationship.get();
    }

    public static String[] getFieldNames() {
        return FIELD_NAMES;
    }