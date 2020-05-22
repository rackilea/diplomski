@Component
@EnableConfigurationProperties
@ConfigurationProperties
public class stat {

    private Map<String, String[]> present = new HashMap<String, String[]>(); 

    public Map<String, String[]> getPresent() {
        return present;
    }
}