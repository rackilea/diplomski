NotificationCompat.Builder builder = new NotificationCompat.Builder(this, 100);
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        NotificationChannel notificationChannel =
                new NotificationChannel(
                        100,
                        "Media PlayBack",
                        NotificationManager.IMPORTANCE_LOW);
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        if (notificationManager != null) {
            notificationManager.createNotificationChannel(notificationChannel);
        }
 }

Intent notificationIntent = new Intent(this, MainActivity.class);
PendingIntent contentIntent =  PendingIntent.getActivity(this, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

builder.setSmallIcon(R.mipmap.ic_launcher_round)
.setContentTitle("Title")
.setContentText("Content")
.setContentIntent(contentIntent); 

Notification notification = builder.build();
startForeground(101, notification);