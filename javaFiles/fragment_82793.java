public class NewsServiceReceiver extends Service {

    private boolean isRunning;
    private Context  contex;
    private Thread backgroundTread;

    @Override
    public IBinder onBind(Intent intent){
        return null;
    }

    @Override
    public void onCreate(){
        this.contex = this;
        this.isRunning = false;
        this.backgroundTread = new Thread(myTask);

    }

    private Runnable myTask = new Runnable() {

        @Override
        public void run() {
            // TODO Auto-generated method stub
            System.out.println("[*******-----------> BACKGROUND  <-----------*******]");

            //------------My Code Here--------------

            stopSelf();
        }
    };


    @Override
    public void onDestroy(){
        this.isRunning = false;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if(!this.isRunning){
            this.isRunning = true;
            this.backgroundTread.start();
        }
        return START_STICKY;
    }

}