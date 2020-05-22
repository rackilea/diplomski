@Configuration
@ComponentScan(basePackages = "com.tpv.req")
@EnableScheduling
@PropertySource(value = "file:/opt/scanner-application.properties")
public class AppConfig implements SchedulingConfigurer {

protected static final Logger logger = LoggerFactory.getLogger(AppConfig.class);

@Override
public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
    taskRegistrar.setScheduler(taskExecutor());
}

@Bean(destroyMethod = "shutdown")
public Executor taskExecutor() {
    return Executors.newScheduledThreadPool(1);
}

@Bean
public static PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurer() {
    PropertySourcesPlaceholderConfigurer pspc = new PropertySourcesPlaceholderConfigurer();
    return pspc;
}
}