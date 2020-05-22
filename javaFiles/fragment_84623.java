@Configuration
@ComponentScan({ ... })
@EnableWebMvc
@ImportResource({ "classpath:spring-config.xml" })
@Import({WebSecurityConfig.class})
public class ApplicationConfig {

}