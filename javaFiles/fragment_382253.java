public class Person extends AbstractEntity {
}

public class PersonRepository extends AbstractRepository<Person> {
}

PersonRepository repo = new PersonRepository();
List<Person> people = repo.list("some SQL");