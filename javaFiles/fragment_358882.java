public class StackConfinement extends Thread {

    private List<Person> people = new ArrayList<>();

    public void setSomeMoreProperty() {
        // Initially stack-confined
        Person person = new Person();

        person.setPersonAddress("NY");
        person.setPersonName("Xyz");

        // does not break stack confinement:
        doSomething(person);
        System.out.println(person);

        // this DOES break stack confinement:
        people.add(person);
    }

    // ...
}