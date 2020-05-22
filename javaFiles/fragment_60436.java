ExecutorService tasker = Executors.newFixedThreadPool(20);
for(double t = 0.0; t<=5.0; t = t + 0.50 ){ // t is time interval
    tasker.execute(new MyRunnable(t));
}
....
....
class MyRunnable implements Runnable
{
    MyRunnable(double i)
    {
       System.out.println(i);
       ...
    }
}