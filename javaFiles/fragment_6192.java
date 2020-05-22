public class Test {
    private boolean isExecuted;
    public synchronized void executeOnce() { 
        if (isExecuted) {
            return;
        } else {
            //do your stuff
            isExecuted = true;
        }
    }
}