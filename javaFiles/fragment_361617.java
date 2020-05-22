public class Person {

    private String name;
    private List<String> phoneNumbers = Collections.emptyList();

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPhoneNumbers(List<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public void addPhoneNumber(String number) {
        phoneNumbers.add(number);
    }

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }
}