import java.util.HashMap;
import java.util.Map;

public class SOPlayground {

    public static void main(String[] args) throws Exception {
        Map<String, Person> people = new HashMap<>();

        Person joe = new Person("Joe", "Doe");
        Person jane = new Person("Jane", "Smith");
        people.put(joe.getFirstName(), joe);
        people.put(joe.getLastName(), joe);
        people.put(jane.getFirstName(), jane);
        people.put(jane.getLastName(), jane);

        for (String key : new String[]{"Joe", "Doe", "Jane", "Smith"}) {
            System.out.println(people.get(key));
        }

    }

    private static class Person {

        String firstName;
        String lastName;

        public Person(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        @Override
        public String toString() {
            return "Person{" + "firstName=" + firstName + ", lastName=" + lastName + '}';
        }

    }
}