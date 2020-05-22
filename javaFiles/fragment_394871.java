// simple definition of a Person Resource in Spring
public class PersonResource extends Resource<Person> {

    public PersonResource(Person content, Link... links) {
        super(content, links);
    }

}

public class Person {
    ...
    String name;
    Integer age;
    // getters/setters omitted for clarity
}