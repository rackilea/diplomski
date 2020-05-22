@Configuration
public class PerformanceloggingConfig {

    @Bean
    public LogWriter performanceLogWriter(){
        return new DefaultLogWriter();
    }

    @Bean
    public JmsPerformanceLogger jmsPerformanceLogger(){
        return new JmsPerformanceLogger();
    }
    @Bean
    public RestPerformanceLogger restPerformanceLogger(){
        return new RestPerformanceLogger();
    }
    @Bean
    public ServicesPerformanceLogger servicesPerformanceLogger(){
        return new ServicesPerformanceLogger();
    }
    @Bean
    public DaoPerformanceLogger daoPerformanceLogger(){
        return new DaoPerformanceLogger();
    }
}