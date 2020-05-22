@Entity
@Table(name = "persons") 
public class Person {
    //...
}

@Query(value = "select * from persons limit 50", nativeQuery = true)
List<Person> getFirst50();