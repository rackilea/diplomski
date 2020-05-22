@Component
@Validated
@PropertySource("classpath:my.properties")
@ConfigurationProperties(prefix = "my")
public class MyService {

    @NotBlank
    private String username;

    public void setUsername(String username) {
        this.username = username;
    }

    ...
}