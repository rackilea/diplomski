public Job job() {

        final Flow masterFlow = new FlowBuilder<Flow>("flow1").start(step("step1")).build();

        final Flow slaveFlow = new FlowBuilder<Flow>("flow2").split(new SimpleAsyncTaskExecutor())
                .add(
                        new FlowBuilder<Flow>("flow2.1").start(step("step2.1")).build(),
                        new FlowBuilder<Flow>("flow2.2").start(step("step2.2")).build())
                .build();

        return (jobBuilderFactory
                .get("job")
                .incrementer(new RunIdIncrementer())
                .start(masterFlow)
                .next(slaveFlow)
                .build())
                        .build();
    }

    private TaskletStep step(final String name) {

        return stepBuilderFactory.get(name)
                .tasklet((StepContribution contribution, ChunkContext chunkContext) -> {

                    System.out.println(name + " start");
                    Thread.sleep(1000);
                    System.out.println(name + " end");

                    return RepeatStatus.FINISHED;
                })
                .build();
    }