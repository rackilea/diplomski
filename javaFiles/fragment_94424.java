@Bean(name = "messageSource")
public ReloadableResourceBundleMessageSource messageSource() {
  ReloadableResourceBundleMessageSource messageBundle = new ReloadableResourceBundleMessageSource();
  messageBundle.setBasename("classpath:messages/messages");
  messageBundle.setDefaultEncoding("UTF-8");
  return messageBundle;
}