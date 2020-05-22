@Configuration
public class MetricsConfiguration {

    @Bean
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    @Qualifier(Metrics.HOURS_WORKED)
    @ConfigurationProperties(prefix = "metrics." + Metrics.HOURS_WORKED)
    public Metric hoursWorked() {
        return new Metric();
    }

    @Bean
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    @Qualifier(Metrics.MONTHLY_DEALS)
    @ConfigurationProperties("metrics." + Metrics.MONTHLY_DEALS)
    public Metric monthlyDeals() {
        return new Metric();
    }

    @Bean
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    @Qualifier(Metrics.MONTHLY_GOAL)
    @ConfigurationProperties("metrics." + Metrics.MONTHLY_GOAL)
    public Metric monthlyGoal() {
        return new Metric();
    }
}