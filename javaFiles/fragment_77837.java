@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@ClassExtractor(PersonClassExtractor.class)
public abstract class Person {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private int age;
    // ...
}