@Configuration
public class ResponsysConfig {

    @NotNull
    @Value("${responsys.username}")
    private String username;

...


}