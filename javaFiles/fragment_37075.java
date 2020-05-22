@Configuration
static class TaskConfiguration implements SchedulingConfigurer {

    //schedule the task dynamically
    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.addTriggerTask(task, trigger);
    }
}