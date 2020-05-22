@Configuration
public class LocaleConfiguration {

    @Bean(name={"localeResolver"})
    public CookieLocaleResolver cookieLocaleResolver() { ... }

}