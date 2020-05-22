//PLACE THIS IN A PACKAGE WHERE YOUR CONTROLLERS ARE
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

@ComponentScan
@Import(RepositoryRestMvcConfiguration.class)
public class WebConfig {
}