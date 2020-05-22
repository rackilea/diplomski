public class MyExecutors {

  private static ExecutorService ex;

  public static synchronized ExecutorService getExecutor(){
    if(ex == null){
        ex = new ThreadPoolExecutor(0, 50, 60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
    }
    return ex;
  }
}