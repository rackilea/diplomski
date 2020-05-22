public class cBT_startcheck extends MainActivity implements Runnable {

   private WeakReference<MainActivity> activityWeakReference;

   cBT_startcheck(MainActivity activity){
       activityWeakReference =new WeakReference<MainActivity>(activity);
   }
   @Override
   public void run() {
       final MainActivity activity =activityWeakReference.get();
       Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
       activity.startAplication(intent)
       }
}