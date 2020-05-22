//updated this bean of yours. the others are new
@Bean
public Job importUserJob(JobCompletionNotificationListener listener) throws Exception {
    return jobBuilderFactory.get("importUserJob")
            .incrementer(new RunIdIncrementer())
            .listener(listener)
            .flow(partitionStep())
            .end()
            .build();
}

@Bean
public Step partitionStep(){
    return stepBuilderFactory.get("partitionStep")
            .partitioner(step1()) //leverage the step you already have
            .partitioner("step1", partitioner())
            .gridSize(10) //# of threads
            .taskExecutor(taskExecutor())
            .build();
}

@Bean
public Partitioner partitioner() {
    //Use this partitioner to add ranges for your reader
    //NOTE: your reader needs to be in @StepScope to pull from the Step Execution Context
    return new YourCustomPartitioner();
}

@Bean
public TaskExecutor taskExecutor() {
    return new SimpleAsyncTaskExecutor();
}