@SpringBootApplication
public class DemoApplication {

  public static void main(String[] args) {
    Locale defaultLocale = determineLocaleFrom(args);
    Locale.setDefault(defaultLocale);

    ApplicationContext context = SpringApplication.run(DemoApplication.class, args);

    MessageSource messageSource = context.getBean(MessageSource.class);
    // when fetching messages, always read from the default locale
    messageSource.getMessage("my.message.code", null, Locale.getDefault());
  }

}