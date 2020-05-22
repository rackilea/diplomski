@ConfigurationProperties("oracle")
public class OracleProperties {

    private String url;

    public String getUrl() {
        return oracleUrl;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}