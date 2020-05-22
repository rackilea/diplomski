@Entity
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    public User() {}    

    public static User createUser(String name) {
        User result = new User();
        result.setName(name);
        return result;
    }

    public void setName(String name) {
        this.name = name;
    }

}