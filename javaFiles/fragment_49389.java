interface IExecutor {
    execute();
}

class Executor1 implements IExecutor {
    private final IExample example;
    public Executor1(IExample example) { this.example = example; }
    execute() {
        example.methodA();
        example.methodC();
    }
}