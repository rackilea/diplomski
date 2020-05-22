NotificationManager mNotifyManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
NotificationCompat.Builder mBuilder = (NotificationCompat.Builder)
            new NotificationCompat.Builder(SettingsActivity.this)
                    .setSmallIcon(R.drawable.ic_notifications_white_24dp)
                    .setContentTitle("Your title")
                    .setContentText("Your message");
    Intent resultIntent = new Intent(SettingsActivity.this, MainActivity.class); //to open an activity on touch notification
    PendingIntent resultPendingIntent = PendingIntent
            .getActivity(SettingsActivity.this, 0, resultIntent, PendingIntent.FLAG_UPDATE_CURRENT);
    mBuilder.setContentIntent(resultPendingIntent);
    Notification notification = mBuilder.build();
    notification.flags |= Notification.FLAG_AUTO_CANCEL;
    mNotifyManager.notify(1, notification);