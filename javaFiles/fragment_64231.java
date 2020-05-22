@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {
...
@Override
public Validator getValidator() {
    LocalValidatorFactoryBean factory = new LocalValidatorFactoryBean();
    factory.setValidationMessageSource(messageSource());
    return factory;
}
...