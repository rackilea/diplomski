@Configuration
@ComponentScan("com.example.tasks")
@EnableScheduling
class Tasks implements SchedulingConfigurer {
    @Bean
    public TaskScheduler cacheScheduler() {
        return new ThreadPoolTaskScheduler();
    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.setTaskScheduler(cacheScheduler());
    }
}