public interface AsyncObject {
    public void invoke();
    public Object check();
}

public class MyMockAsyncObject implements AsyncObject {

    private long delay;
    private long startTimeMillis;

    public MyMockAsyncObject(long delay) {
        this.delay = delay;
    }

    public void invoke() {
        startTimeMillis = now();
    }

    public Object check() {
        if (now() - startTimeMillis > delay) {
            return new Object();
        } else {
            return null;
        }
    }
}

public class Waiter {

    public AsyncObject myAsyncObject;

    public Waiter(AsyncObject async) {
        this.myAsyncObject = async;
    }

    public Object getResult() {
        myAsyncObject.invoke();
        return this.waitForResult();
    }

    private Object waitForResult() {
        while(// is not timed out) {
            // wait a while
            myAsyncObject.check(); 
            // return result if it's there
        }
        throw new Exception();
    }
}