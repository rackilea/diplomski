@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private String username;
    private Integer age;

    // Getter, Setter, Constructors as required

}