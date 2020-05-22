@Entity
@Table(name = "contact")
public class Contact {

    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    public Contact() {
    }
    // etc.