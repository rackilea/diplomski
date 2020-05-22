@Component
@EnableConfigurationProperties
@ConfigurationProperties
public class stat {

    private Map<String, Map<String, String[]>> parent = new HashMap<String, Map<String, String[]>>();

    public Map<String, Map<String, String[]>> getParent() {
        return parent;
    }
}