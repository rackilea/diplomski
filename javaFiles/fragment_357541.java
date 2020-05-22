@Bean
@StepScope
public Step slaveStep(@Value("#{stepExecutionContext[userId]}") String userId) {
    return this.stepBuilderFactory.get("partStep").tasklet(((contribution, chunkContext) -> {
        log.info("Current thread=" + Thread.currentThread().getName() + " and i process userId=" + userId);
        return RepeatStatus.FINISHED;
    })).build();
}