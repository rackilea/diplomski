@Entity
public class EUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id; 
    @Column(nullable = false)
    private String userName;

    @ManyToMany(fetch=FetchType.EAGER)
    private List<UserRole> roles;


        //getters and setters method here

}