@Component
@ConfigurationProperties("ignored")
@RefreshScope
public class Config {
    private List<String> path;

    public List<String> getPath() {
        return path;
    }

    public void setPath(List<String> path) {
        this.path = path;
    }
}