public class DLService extends Service {

@Override
 public int onStartCommand(Intent intent, int flags, int startId) {
  Notification note=new Notification(R.drawable.somegraphics, "some title", randomnr);
  Intent i=new Intent(this, ActivityClassToOpenWhenClicked.class);
  i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_SINGLE_TOP);
  PendingIntent pi=PendingIntent.getActivity(this, 0, i, 0);
  note.setLatestEventInfo(this, "downloadmanager","downloading.. nothing", pi);
  note.flags|=Notification.FLAG_NO_CLEAR;
  startForeground(1337, note); 
 // if (intent.hasExtra("dlurl")) { 
    new Thread(new Runnable() {
         public void run() {
        new Client("http://yourfile.com/file.jpg");     
     }
    }).start();
  return START_NOT_STICKY;
 }

class Client {
  public Client(String filetodownload) throws Exception {
  //do your http connection. for example one download  #
  // HttpUrlConnection httpConnection = new .....
 }
}
}