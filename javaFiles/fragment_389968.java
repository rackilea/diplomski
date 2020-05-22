public class Person {

    private String firstName;

    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }   

    public static void main(String[] args) {
        Person person = new Person();
        person.setFirstName("James");
        person.lastName = "Jameson";

        DtoRepository<Person> personRepository = new DtoRepository<Person>();
        personRepository.update(person);
    }
}