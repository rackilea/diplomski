public class Person {

    private String name;
    private Integer age;

}


public class PersonServiceImpl implements PersonService {

    public void changeAge(Integer personId, Integer newAge) {
        Person person = em.getReference(Person.class, personId);

        // person is a proxy
        person.setAge(newAge);
    }

}