@Entity
public class Person extends Model {

    @Id
    private Long id;

    private String value;

    public Long getId() {
        return id;
    }

    public String getValue() {
        return value;
    }
}