public class AlarmReceiver extends BroadcastReceiver {

  Context myContext;

  @Override
  public void onReceive(Context context, Intent intent) {
    Toast.makeText(context, "Alarm received!", Toast.LENGTH_LONG).show();
    myContext = context;
    showNotification();

  }

 public void showNotification()
  {
    String link = "http://www.login.lt/apdovanojimai/";
    Intent intent1 = new Intent(Intent.ACTION_VIEW);
    intent1.setData(Uri.parse(link));
    PendingIntent pIntent = PendingIntent.getActivity(myContext, 0, intent1, 0);

    NotificationCompat.Builder n = new NotificationCompat.Builder(myContext)
            .setContentTitle("LOGIN 2015")
            .setContentText("hello")
            .setSmallIcon(R.drawable.ic_launcher)
            .setContentIntent(pIntent)
            .setAutoCancel(true);

    NotificationManager notificationManager =
            (NotificationManager) myContext.getSystemService(Context.NOTIFICATION_SERVICE);

    notificationManager.notify(0, n.build());
   }

}