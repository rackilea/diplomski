@Bean
public MethodValidationPostProcessor methodValidationPostProcessor() {
    MethodValidationPostProcessor mvProcessor = new MethodValidationPostProcessor();
    mvProcessor.setValidator(validator());
    return mvProcessor;
}           

@Bean
public LocalValidatorFactoryBean validator() {
    LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
    validator.setProviderClass(HibernateValidator.class);
    validator.afterPropertiesSet();
    return validator;
}