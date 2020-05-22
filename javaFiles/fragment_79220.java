// helper method to create a split flow out of a List of steps
private static Flow createParallelFlow(List<Step> steps) {
    SimpleAsyncTaskExecutor taskExecutor = new SimpleAsyncTaskExecutor();
    // -1 indicates no concurrency limit at all, steps.size is in this case 2 threads, 1 means just 1 thread. 
    taskExecutor.setConcurrencyLimit(steps.size());

    List<Flow> flows = steps.stream() // we have to convert the steps to a flows
        .map(step -> //
                new FlowBuilder<Flow>("flow_" + step.getName()) //
                .start(step) //
                .build()) //
            .collect(Collectors.toList());

    return new FlowBuilder<SimpleFlow>("parallelStepsFlow").split(taskExecutor) //
        .add(flows.toArray(new Flow[flows.size()])) //
        .build();
}