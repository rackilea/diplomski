public class AlarmReceiver extends BroadcastReceiver {

//MainActivity main = new MainActivity();

    Context cxt;

    @Override
    public void onReceive(Context arg0, Intent arg1) {
        Toast.makeText(arg0, "Alarm received!", Toast.LENGTH_LONG).show();
        cxt = arg0;

        //main.addNotification();
        addNotification();

    }

    public void addNotification() {
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(cxt)
                        .setSmallIcon(R.drawable.icon_transperent)
                        .setContentTitle("Achieve Alert!")
                        .setContentText("This is a reminder for your deadline!");

        Intent notificationIntent = new Intent(cxt, MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(cxt, 0, notificationIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(contentIntent);

        // Add as notification
        NotificationManager manager = (NotificationManager)cxt.getSystemService(Context.NOTIFICATION_SERVICE);
        builder.setVibrate(new long[] { 0, 1000, 1000, 1000, 1000 });
        manager.notify(0, builder.build());
    }

}