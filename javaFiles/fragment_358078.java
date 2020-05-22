NotificationCompat.Builder mBuilder =
            new NotificationCompat.Builder(this)
                    .setSmallIcon(R.drawable.ic_launcher)
                    .setContentTitle("title")
                    .setContent(mRemoteControl);
    Intent notificationIntent = new Intent(this, YourActivity.class);
    PendingIntent contentIntent = PendingIntent.getActivity(
            this, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
    mBuilder.setContentIntent(contentIntent);
    mNM.notify(1000,mBuilder.build());