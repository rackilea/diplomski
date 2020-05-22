import org.springframework.context.annotation.Configuration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@Configuration
@EnableConfigurationProperties(TestProperties.class)
public class TestConfiguration {

    @Autowired
    private TestProperties config;

    // do whatever with properties

}