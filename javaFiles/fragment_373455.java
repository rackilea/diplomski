public abstract class Job implements Runnable {
    protected Integer jobId;

    public void start(Integer jobId) {
        this.jobId = jobId;
        try {
            new Thread(this).start();
        } catch (Exception e) {
            e.getMessage();
        }       
    }
}

public class Test extends Job {
    @Override
    public void run() {
        System.out.println(jobId);
    }
}