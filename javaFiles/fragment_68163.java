@Configuration
@EnableWebMvc
public class MvcConfig extends WebMvcConfigurerAdapter {

[...]

@Bean    
public MessageSource messageSource() {
    ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
    messageSource.setBasename("/WEB-INF/messages/messages");
    return messageSource;
}