@Entity
public class User {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min = 2, max = 15)
    private String name;

    @NotNull
    private Integer age;

    @NotNull
    private Boolean hungry;
}