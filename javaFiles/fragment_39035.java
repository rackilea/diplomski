@Bean
public SchedulerFactoryBean schedulerFactory(DataSource dataSource, JobFactory jobFactory)
        throws IOException {
    SchedulerFactoryBean factory = new SchedulerFactoryBean();
    factory.setBeanName("myscheduler");
    factory.setDataSource(dataSource);
    factory.setJobFactory(jobFactory);
    factory.setQuartzProperties(getQuartzProperties());
    if (!System.getProperty(SCHEDULER_NAME).contains("myscheduler")) {
        factory.setAutoStartup(false);
    }
    return factory;
}