private void setAlarm(Intent intent) {
    int notificationId = intent.getIntExtra("notificationId", 0);
    String text = intent.getStringExtra("text");
    Intent mainIntent = new Intent(this, MainActivity.class);
    PendingIntent contentIntent = PendingIntent.getActivity(this, 0, mainIntent, 0);
    NotificationManager myNotificationManager =
            (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);
    Notification.Builder builder = new Notification.Builder(this);
    builder.setSmallIcon(android.R.drawable.ic_dialog_info)
            .setContentTitle("Wake up!")
            .setContentText(text)
            .setWhen(System.currentTimeMillis())
            .setContentIntent(contentIntent);
    myNotificationManager.notify(notificationId, builder.build());
}

@Override
protected void onHandleIntent(@Nullable Intent intent) {
    setAlarm(intent);
    Intent service = new Intent(this, BootService.class);
    stopService(service);
}