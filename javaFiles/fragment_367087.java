interface Task {
    void doSomething();
}

interface Factory {
    Task makeTask(String taskDescription);
}

Map<String, Factory> taskMap = new HashMap<>();

void init() {
    taskMap.put("sayHello", new Factory() {
        @Override
        public Task makeTask(String taskDescription) {
            return new Task() {
                @Override
                public void doSomething() {
                    System.out.println("Hello" + taskDescription);
                }
            };
        }
    });
}

void onTask(String taskName, String taskDescription) {
    Factory factory = taskMap.get(taskName);
    if (factory == null) {
        System.out.println("Unknown task: " + taskName);
    }
    Task task = factory.makeTask(taskDescription);

    // execute task somewhere
    new Thread(task::doSomething).start();
}