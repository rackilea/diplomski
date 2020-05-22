public class PersonController {

    List<Person> allPeople = new ArrayList<Person>();

    public PersonController() {
        this.populate();
    }

    public void populate() {
        Person person = new Person("Jeff");
        person.setName("Jeff");
        allPeople.add(person);
    }
    /* Omitted Accessors */
}