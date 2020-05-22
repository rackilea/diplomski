@ManagedBean
@RequestScoped
public class Register {

    @ManagedProperty("#{config}")
    private Config config;

    @PostConstruct
    public void init() {
        // ...
    }

    // ...
}