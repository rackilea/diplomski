public class CoresTimerTask extends TimerTask {

    private boolean hasStarted = false;

    @Overrides
    public void run() {
        this.hasStarted = true;
        //rest of run logic here...
    }

    public boolean hasRunStarted() {
        return this.hasStarted;
    }
}