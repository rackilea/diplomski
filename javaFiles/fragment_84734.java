public class Person {

    private String code;
    private String name;
    private String address;
    private String number;

    public Person(String code, String name, String address, String number) {
        this.code = code;
        this.name = name;
        this.address = address;
        this.number = number;            
    }

    public String geCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}