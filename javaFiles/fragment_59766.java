@Data
@NoArgsConstructor
@Entity
@RestResource(rel="people", path="people")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String firstName;
    private String lastName;

    @JsonSerialize(using = MyLocalDateSerializer.class)
    private LocalDate birthDate;

    public Person(String firstName, String lastName, String birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = LocalDate.parse(birthDate);
    }
}