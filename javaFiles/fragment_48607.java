private void sendNotification(String msg) {
    Intent intent = new Intent(this, MainActivity.class);
    intent.putExtra("yourpackage.notifyId", NOTIFICATION_ID);
    PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent,
            PendingIntent.FLAG_UPDATE_CURRENT);
    NotificationCompat.Builder mBuilder =  new NotificationCompat.Builder(this)
            .setContentTitle("EXX")
            .setSmallIcon(R.drawable.ic_launcher)
            .setStyle(new NotificationCompat.BigTextStyle()
            .bigText(msg))
            .addAction(getNotificationIcon(), "Action Button", pIntent)
            .setContentIntent(pIntent)
            .setContentText(msg)
            .setOngoing(true);
    mNotificationManager.notify(NOTIFICATION_ID, mBuilder.build());
}