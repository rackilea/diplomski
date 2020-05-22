public class ScheduledJob {

    private Timer timer;

    public ScheduledJob(Timer timer){
        this.timer = timer;
    }

    @PreDestroy
    public void destroy(){
        timer.cancel();
    }
}