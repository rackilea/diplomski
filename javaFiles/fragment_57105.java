@Bean
public Job splitJob(@Qualifier("foo") Flow foo, @Qualifier("foo") Flow bar) {
    FlowBuilder<Flow> flowBuilder = new FlowBuilder<>("split");

    Flow flow = flowBuilder.split(new SimpleAsyncTaskExecutor())
            .add(foo, bar)
            .end();

    return jobBuilderFactory.get("splitJob")
            .start(myStep1())
            .next(myStep2())
            .on("COMPLETED").to(flow)
            .end()
            .build();
}