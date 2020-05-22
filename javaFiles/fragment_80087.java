Intent notifIntent = new Intent(this, SensorService.class);
    PendingIntent pi = PendingIntent.getActivity(this, 0, notifIntent, 0);

    Notification notification = new NotificationCompat.Builder(this)
            .setSmallIcon(R.drawable.smslogo_100x100)
            .setColor(ContextCompat.getColor(this, R.color.colorAccent))
            .setContentTitle(getResources().getString(R.string.app_name))
            .setContentText("Running")
            .setContentIntent(pi)
            .build();
    startForeground(101010, notification);

}