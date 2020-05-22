@Component
public class MyAppProperties {

    private String clientActivitiesUrlString;

    @PostConstruct
    public void init() {
        ContactHelper.setClientActivitiesUrlString(this.getClientActivitiesUrlString());
    }
    // Getters/Setters
}