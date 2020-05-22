@Configuration
public class ApplicationConfig {
    @Resource
    private Config config;
    @Autowired
    private ApplicationContext appContext;

    @Bean
    public Object application() throws ParseException {
        return new SampleApp(
                (appContext.getBean("beanNameFromConfig"));
    }
}