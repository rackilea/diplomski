if (Build.VERSION.SDK_INT >= 26) {
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);
        mBuilder.setSmallIcon(R.drawable.ic_launcher);
        mBuilder.setContentTitle("FCM Notif");
        mBuilder.setContentText("Processing notification..");
        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        // notificationID allows you to update the notification later on.
        mNotificationManager.notify(100, mBuilder.build());
        startForeground(100, mBuilder.mNotification);
    }