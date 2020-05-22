@Bean(name = "messageSource")
@Profile(value = {"dev","prod"})
public MessageSource messageSource() {
    ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
    messageSource.setBasenames(
            "/i18n/ir/kia/industry/webapp/entity",
            "/i18n/ir/kia/industry/webapp/formErrors",
            "/i18n/ir/kia/industry/webapp/frontend",
            "/i18n/ir/kia/industry/webapp/frontendPages");
    messageSource.setCacheSeconds(5);
    return messageSource;
}

@Bean(name = "messageSource")
@Profile("test")
public MessageSource testMessageSource() {
    ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
    return messageSource;
}