class Person {
    private String name;

    @Override
    public String toString() {
        return "Person [name=" + this.name + "]";
    }
}

class Address {
    private String town;
}

public class Test {
    public static void main(String... args) {
        Person person = new Person();
        Address address = new Address();

        System.out.println("Person is : " + person);
        System.out.println("Address is : " + address);
    }
}