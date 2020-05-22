public void send(View v) {
    NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    Context context = getApplicationContext();
    Intent notificationIntent = new Intent(context, TestNotificationActivity.class);
    PendingIntent contentIntent = PendingIntent.getActivity(context, 0, notificationIntent, PendingIntent.FLAG_CANCEL_CURRENT);
    NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
    Notification notification = builder
            .setContentIntent(contentIntent)
            .setContentTitle("this is title")
            .setContentText("this is content")
            .setWhen(System.currentTimeMillis())
            .setSmallIcon(R.mipmap.ic_launcher)
            .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
            .build();
    manager.notify(NOTIFY_ID, notification);
}