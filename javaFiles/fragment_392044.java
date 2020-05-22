public interface PersonLookup {

    void add(Person person);

    Set<Person> get(String key); 
}

public class Person {
    private String firstName, lastName;
    private Double salary;

    public Person(String firstName, String lastName, Double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    ... getters ...

    ... equals() and hashCode() ...
}