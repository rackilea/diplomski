private void sendNotification(String title, String body) {

        Random random = new Random();
        int m = random.nextInt(9999 - 1000) + 1000;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            String CHANNEL_ID = "my_channesl_01";
            CharSequence name = "NEWS";
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationManager mNotificationManager =
                    (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            NotificationChannel mChannel = null;
            mChannel = new NotificationChannel(CHANNEL_ID, name, importance);
            mNotificationManager.createNotificationChannel(mChannel);
            Intent showFullQuoteIntent = new Intent(this, Home.class);
            showFullQuoteIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);

            int uniqueInt = (int) (System.currentTimeMillis() & 0xfffffff);
            PendingIntent pendingIntent = PendingIntent.getActivity(this, uniqueInt, showFullQuoteIntent, PendingIntent.FLAG_UPDATE_CURRENT);

            Uri notificationSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

            Notification notification = new NotificationCompat.Builder(this.getApplicationContext(), "")
                    .setSmallIcon(R.drawable.logo)
                    .setContentTitle(title)
                    .setLargeIcon(BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.logo))
                    .setColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary))
                    .setAutoCancel(false)
                    .setSound(notificationSound)
                    .setContentIntent(pendingIntent)
                    .setContentText(body)
                    .setChannelId(CHANNEL_ID)
                    .build();

            mNotificationManager.notify(m, notification);
        }
        else
        {
            Intent showFullQuoteIntent = new Intent(this, Home.class);
            showFullQuoteIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            int uniqueInt = (int) (System.currentTimeMillis() & 0xfffffff);
            PendingIntent pendingIntent = PendingIntent.getActivity(this, uniqueInt, showFullQuoteIntent, PendingIntent.FLAG_UPDATE_CURRENT);
            Uri notificationSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

            Notification notification = new NotificationCompat.Builder(getApplicationContext(), "")
                    .setSmallIcon(R.drawable.logo)
                    .setContentTitle(title)
                    .setLargeIcon(BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.logo))
                    .setColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary))
                    .setAutoCancel(false)
                    .setSound(notificationSound)
                    .setContentIntent(pendingIntent)
                    .setContentText(body)
                    .build();

            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            notificationManager.notify(m, notification);
        }
    }