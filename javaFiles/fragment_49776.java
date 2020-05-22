public class Main {

    static Thread gameThread= null;

    public static void main(String[] args) throws Exception {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(1 /*single-threaded executor service*/,
             new ThreadFactory(){
                  public Thread newThread(Runnable r){
                      gameThread = new Thread(r);
                      System.out.println(gameThread);
                      return gameThread;
                  }
        });


        service.scheduleAtFixedRate(new Runnable(){
            @Override
            public void run() {
                /*do stuff*/
            }

        }, 0,15,TimeUnit.MILLISECONDS);
    }
}