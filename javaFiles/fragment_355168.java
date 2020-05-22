@Entity
public class User {
    @Id
    private Long id;

    @OneToOne(mappedBy="user")
    private Address address;
    // other fields
}