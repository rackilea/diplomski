@EnableWebMvc
@ImportResource({ "/WEB-INF/spring-security.xml", "/WEB-INF/spring-webflow.xml"})
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    // ...

}