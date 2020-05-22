/**
 * Web configuration.
 *
 * Since 1.0.0
 */
@Configuration
@PropertySource("classpath:i18n/urls.properties")
public class WebConfig extends WebMvcConfigurerAdapter {

    /**
     * Locale resolver.
     *
     * @return <code>LocaleResolver</code>
     */
    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver localeResolver = new SessionLocaleResolver();
        localeResolver.setDefaultLocale(Locale.CANADA);
        return localeResolver;
    }

    /**
     * Locale change interceptor.
     *
     * @return <code>LocaleChangeInterceptor</code>
     */
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("lang");
        return localeChangeInterceptor;
    }

    /** {@inheritDoc} */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
        registry.addInterceptor(localeChangeInterceptor());
    }

}