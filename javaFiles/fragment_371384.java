@Test
public void process() throws Exception {
    CallableWithParam callable = new CallableWithParam() {
    @Override
        public String call() {
             // an anonymous inner class is almost a lambda ;)
            return "my param is: " + param + "in subclass";
        }
    };
    callable.setParam(3);
    ExecuteAlerterTask<String> executeAlerterTask = new ExecuteAlerterTask<>();
    List<String> result = executeAlerterTask.process("TaskName", callable);
    result.forEach(System.out::println);
}