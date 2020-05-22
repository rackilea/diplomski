public class TaskTimer extends Thread {

private java.util.concurrent.LinkedBlockingQueue<Runnable> taskQueue;
private int timeToWait;
private Long lastTime = -1l;

public TaskTimer(int time)
{
    if(time<0)
        throw new IllegalStateException("time can not negative");

    timeToWait = time;
    taskQueue = new java.util.concurrent.LinkedBlockingQueue<>();
}


void  scheduleTask(Runnable task) throws InterruptedException {
    taskQueue.put(task);
}

boolean  tryScheduleTask(Runnable task) {
    return taskQueue.add(task);
}

@Override
public void run() {

    while (true)
    {
        try {
            Runnable a = taskQueue.take();
            if(!(lastTime==-1 || System.currentTimeMillis()-lastTime>timeToWait))
            {
                //so wait !
                synchronized (lastTime)
                {
                    lastTime.wait(timeToWait-(System.currentTimeMillis()-lastTime));
                }

            }
            try{
                a.run();
                lastTime = System.currentTimeMillis();
            }catch (Throwable e)
            {
                //todo handle e
            }
        } catch (InterruptedException e) {

            break;
        }

    }

}
}