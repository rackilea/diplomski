public JobLauncher createJobLauncher() {
    ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
    taskExecutor.setCorePoolSize(4);
    taskExecutor.setMaxPoolSize(4);
    taskExecutor.afterPropertiesSet();

    SimpleJobLauncher launcher = (SimpleJobLauncher) super.createJobLauncher();
    launcher.setTaskExecutor(taskExecutor);
    return launcher;
}