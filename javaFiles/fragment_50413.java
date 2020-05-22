@ManagedBean
@RequestScoped
public class Activation {

    @ManagedProperty(value="#{param.key}")
    private String key;

    private boolean valid;

    @PostConstruct
    public void init() {
        // Get User based on activation key.
        // Delete activation key from database.
        // Login user.
    }

    // ...
}