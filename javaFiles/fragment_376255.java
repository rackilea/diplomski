public class MyCallable implements Callable {
    private Object param1;
    private Object param2;
    private Object param3;

    public MyCallable(Object param1, Object param2, Object param3) {
        this.param1 = param1;
        this.param2 = param2;
        this.param3 = param3;
    }

    public Object Callable() {
        ...
    }
}