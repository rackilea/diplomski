import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TokenResult {
    private String access_token;

    // you don't need this
    // private String expires_in;
}