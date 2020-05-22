private static final int MINIMUM_TIME_LAPSE=60000; // 1 min

private static final int TIMEOUT=1800000; // 30 min

private long previousTime;

private TimerTask timerTask;

private synchronized void scheduleTimeoutIfNecessary()
{
    long currentTime=System.currentTimeMillis();
    if (currentTime-this.previousTime >= MINIMUM_TIME_LAPSE)
    {
        if (this.timerTask!=null)
        {
            this.timerTask.cancel();
        }
        this.timerTask=new ResetServiceTimerTask());
        timer.schedule(this.timerTask, TIMEOUT);
        this.previousTime=currentTime;
    }
}