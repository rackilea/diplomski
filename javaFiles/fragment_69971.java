@Entity
public class Employee {

    @Id
    @GeneratedValue
    Long id;

    @Column
    String name;

    @Column
    int age;

    @Column
    @Convert(converter = GenderConverter.class)
    Gender gender;
}