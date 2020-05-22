NotificationManager notificationManager = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);
    String NOTIFICATION_CHANNEL_ID = "my_channel_id_01";

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        NotificationChannel notificationChannel = new NotificationChannel(NOTIFICATION_CHANNEL_ID, "My Notifications", NotificationManager.IMPORTANCE_MAX);

        // Configure the notification channel.
        notificationChannel.setDescription("Channel description");
        notificationChannel.enableLights(true);
        notificationChannel.setLightColor(Color.RED);
        notificationChannel.setVibrationPattern(new long[]{0, 1000, 500, 1000});
        notificationChannel.enableVibration(true);
        notificationManager.createNotificationChannel(notificationChannel);
    }

    // assuming your main activity
    NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(MainActivity.this, NOTIFICATION_CHANNEL_ID);
    PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, getIntent(), 0);
    notificationBuilder.setAutoCancel(true)
            .setDefaults(Notification.DEFAULT_ALL)
            .setCategory(Notification.CATEGORY_CALL)
            .setOngoing(true)
            .setWhen(System.currentTimeMillis())
            .setSmallIcon(R.drawable.ic_launcher)
            .setTicker("Hearty365")
            .setPriority(Notification.PRIORITY_MAX)
            .setContentTitle("Default notification")
            .setContentText("Lorem ipsum dolor sit amet, consectetur adipiscing elit.")
            .setFullScreenIntent(pendingIntent,true)
            .setContentInfo("Info");

    notificationManager.notify(/*notification id*/1, notificationBuilder.build());