@Configuration
public class StrubConfig {

    @Autowired
    private FormattingConversionService conversionService;

    @PostConstruct
    public void registerCustomConverter() {
        conversionService.addConverter(new TempReadingSourceConverter());
    }

}