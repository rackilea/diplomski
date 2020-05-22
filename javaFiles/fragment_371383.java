public class CallableWithParam implements Callable<String> {

    // protected for subclassing call()
    // volatile for multi-threaded reasons
    protected volatile int param = 0;

    public void setParam(int param) {
        this.param = param;
    }

    @Override
    public String call() {
        return "my param is: " + param;
    }

}