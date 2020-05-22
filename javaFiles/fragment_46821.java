@Inject private Executor executor;  // can be singleton

public void someMethod() {
    ExecutorCompletionService ecs1 = new ExecutorCompletionService(executor);
    ExecutorCompletionService ecs2 = new ExecutorCompletionService(executor);

    // ExecutorCompletionService should be scoped per instance

    ecs1.submit(task1)
    ecs1.submit(task2);
    ecs1.submit(task3);

    ecs2.submit(task4)
    ecs2.submit(task5);
    ecs2.submit(task6);

    // ecs1 `take` will only return tasks submitted to ecs1
    // ecs2 `take` will only return tasks submitted to ecs2

}