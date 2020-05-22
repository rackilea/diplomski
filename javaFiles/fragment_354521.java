public class MyRoutine extends TimerTask {
    private final FileHandler handler;

    public MyRoutine(FileHandler hander) {
        this.handler = handler;
    }

    public void run() {
        // use handler here 
        handler.doSomething();
    }
}