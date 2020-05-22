public class MyService {
    public static void myMethod(){
        if(MyPlugin.instance != null){
            Activity cordovaActivity = MyPlugin.instance.cordovaInterface.getActivity();
            Context applicationContext = cordovaActivity.getApplicationContext();

            Intent intent = new Intent(applicationContext, cordovaActivity.getClass());
            intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            PendingIntent contentIntent = PendingIntent.getActivity(applicationContext,0, intent, Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            NotificationCompat.Builder builder = new NotificationCompat.Builder(applicationContext, myChannelID).setContentIntent(contentIntent);
        }
    }
}