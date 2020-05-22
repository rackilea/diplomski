Intent intent=new Intent(getApplicationContext(),MainActivity.class);
    Uri defaultSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
    PendingIntent pendingIntent=PendingIntent.getActivity(getApplicationContext(), 1, intent, 0);
    Notification notification=new NotificationCompat.Builder(getApplicationContext(), CHANNEL_ID)
            .setContentText(message)
            .setSound(defaultSound)
            .setContentIntent(pendingIntent)
            .setSmallIcon(android.R.drawable.sym_action_chat)
            .setWhen(System.currentTimeMillis())
            .setPriority(Notification.PRIORITY_MAX)
            .build();

    NotificationManager notificationManager=(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        String CHANNEL_ID="channel";
        NotificationChannel notificationChannel=new NotificationChannel(CHANNEL_ID,"channel",NotificationManager.IMPORTANCE_HIGH);
        notificationManager.createNotificationChannel(notificationChannel);
    }
    notificationManager.notify(1, notification);