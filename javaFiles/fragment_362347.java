public class MyUtils {
    private static UIUpdater worker = null;
    private static ExecutorService exeSrv = Executors.newFixedThreadPool(1);

    public static void handleStateChange(){
        if(tabSwitcherThread == null || !tabSwitcherThread.isAlive()){
            worker = new UIUpdater();
        }     

        //this call does not block 
        exeSrv.submit(worker, new Object());     
    }

    private static class UIUpdater implements Runnable{
        @Override
        public void run() {

           //do server request and update ui.
        }
   }
}