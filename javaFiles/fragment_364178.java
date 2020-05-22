@Entity
public class Contact {
    @Id @GeneratedValue
    public Long id;

    @ManyToOne(optional = false)
    public Account account;

    // getters, setters, equals, hashCode

}