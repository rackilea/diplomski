@Entity
@Table(name = "some_table")
public class SomeObject implements Serializable {

    static final long serialVersionUID = <some value>;

    @Id
    @GeneratedValue
    protected Long id;

    @Column
    protected String name;

    @Column
    protected int value;

    // default constructor
    // getters, setters
    // equals, hashCode, toString
    // other methods
}