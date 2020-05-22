public void sendNotification(View view)  
    { 
            NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                NotificationChannel notificationChannel =
                        new NotificationChannel("M_CH_ID", "M_CH_ID", NotificationManager.IMPORTANCE_DEFAULT);
                notificationChannel.setDescription("Test");
                nm.createNotificationChannel(notificationChannel);
            }
            NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this, "M_CH_ID");

            notificationBuilder.setAutoCancel(true)
                    .setDefaults(Notification.DEFAULT_ALL)
                    .setWhen(System.currentTimeMillis())
                    .setSmallIcon(R.drawable.ic_add)
                    .setTicker("Hearty365")
                    .setContentTitle("Default notification")
                    .setContentText("Random words")
                    .setContentInfo("Info");

            nm.notify(1, notificationBuilder.build()); 
    }