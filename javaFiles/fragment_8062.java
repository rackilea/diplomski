@ConfigurationProperties(prefix = "config")
@Component
public class SampleConfigProperties {

    private List<String> entry;

    public List<String> getEntry() {
        return entry;
    }

    public void setEntry(List<String> entry) {
        this.entry = entry;
    }
}