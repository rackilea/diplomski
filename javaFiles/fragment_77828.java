Intent notificationIntent = new Intent(this, TimerActivity.class);
    notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
    PendingIntent intent = PendingIntent.getActivity(this, 0, notificationIntent, 0);

    NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this)
            .setSmallIcon(R.drawable.gear_icon)
            .setContentTitle("Title")
            .setContentIntent(intent)
            .setPriority(2)
            .setContentText("Content text")
            .setAutoCancel(true);
    mNotificationManager = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);
    mNotificationManager.notify(0, mBuilder.build());