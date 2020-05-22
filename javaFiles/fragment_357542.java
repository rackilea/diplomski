@Bean
public Step slaveStep() {
    return this.stepBuilderFactory.get("partStep").tasklet(tasklet(null)).build();
}

@Bean
@StepScope
public Tasklet tasklet(@Value("#{stepExecutionContext[userId]}") String userId) {
    return (contribution, chunkContext) -> {
        log.info("Current thread=" + Thread.currentThread().getName() + " and i process userId=" + userId);
        return RepeatStatus.FINISHED;
    };
}