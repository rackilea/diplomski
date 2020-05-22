public class Data {
    private String name;
    private String phone;
    private String address;
    private String city;
    private String state;
    private String postalCode;
    private String link;
    public Data(String[] data) { 
        name = data[0];
        phone = data[1];
        address = data[2];
        city = data[3];
        state = data[4];
        postalCode = data[5];
        link= data[6];
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getLink() {
        return link;
    }
}