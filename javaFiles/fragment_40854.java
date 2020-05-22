@Entity
@Table(name = "defaultaccounts")
public class DefaultAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long      id;

    @Column(name = "email", nullable = false, unique = true)
    private String    email;

    @Column(name = "password", nullable = false)
    private String    password;

    @ElementCollection
    private Set<Long> managerAccounts = new HashSet<Long>();

    public DefaultAccount(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public DefaultAccount(String email, String password, Set<Long> accounts) {
        this(email, password);
        this.managerAccounts.addAll(accounts);
    }