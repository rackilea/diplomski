@Autowired
private MessageSource messageSource;

@Bean
public LocalValidatorFactoryBean validator() {
     LocalValidatorFactoryBean validatorFactoryBean = new LocalValidatorFactoryBean();
     validatorFactoryBean.setValidationMessageSource(messageSource);

     return validatorFactoryBean;
}

@Override
public Validator getValidator() {
     return validator();
}