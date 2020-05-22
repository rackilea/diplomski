@Configuration
public class AppConfig {

    @Autowired
    private NumberFormatter numberFormatter;

    @Autowired
    private LocalizationHelper localizationHelper;

    @Bean
    public CurrencyUtil curencyUtil() {
        return new CurrencyUtil(localizationHelper, numberFormatter);
    }

    // ...
}