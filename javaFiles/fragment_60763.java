public class Person {

    private String firstName;
    private String lastName;

    public int index;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String toString() {
        return lastName + firstName + (index != 0 ? index : "");
    }
}