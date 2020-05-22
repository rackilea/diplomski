ParallelExecutor executor = new ParallelExecutor();
executor.execute(new ConcreteExecutionStep());

// manual shutdown
Thread.sleep(30 * 1000);
executor.stop();