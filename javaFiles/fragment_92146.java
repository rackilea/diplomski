import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableTimer {

public static void main(String[] args) {
    MyCallableThread myThread = new MyCallableThread();
    Timer timer = new Timer();
    MyTask theTask = new MyTask();
    theTask.addThread(myThread);

    // Start in one second and then every 10 seconds
    timer.schedule( theTask , 1000, 10000 );
}
}

class MyTask extends TimerTask
{
MyCallableThread timerThread = null;
ExecutorService executor;

public MyTask() {
    executor = Executors.newCachedThreadPool();
}

public void addThread ( MyCallableThread thread ) {
    this.timerThread = thread;
}

@Override
public void run()
{
    System.out.println( "MyTask is doing something." );
    if ( timerThread != null ) {
        boolean result;
        Future<Boolean> resultObject = executor.submit( timerThread );

        try {
            result = resultObject.get();
            System.out.println( "MyTask got " + result + " from Thread.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    } else {
        System.out.println( "No Thread set." );
    }
}

}

class MyCallableThread implements Callable<Boolean> {

@Override
public Boolean call() throws Exception {
    Boolean status = true;
    System.out.println( "MyCallableThread is returning " + status + ".");
    return status;

}
}