ExecutorService executor = Executors.newFixedThreadPool(5);`
executor.execute(new MyRunnableWorker());

public class MyRunnableWorker implements Runnable{
    private String ip;
    private String threadName;
    private int threadTimeout = 10;

    public MyRunnableWorker(String ip){
        this.ip = ip;
    }

    public MyRunnableWorker(String ip,int threadTimeout,String threadName){
        this.ip = ip;
        this.threadTimeout = threadTimeout;
        this.threadName = threadName;

        System.out.prinln("MyRunnableWorker constructor has been called!");
    }

    @Override
    public void run(){    {
        // do some stuff that takes time ....
    }
}