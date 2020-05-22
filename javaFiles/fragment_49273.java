private void sendNotification(String body,Context context) {

        Intent intent = new Intent(context, WelcomeActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0/*Request code*/, intent, PendingIntent.FLAG_ONE_SHOT);
        //Set sound of notification
        Uri notificationSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        Bitmap icon = BitmapFactory.decodeResource(context.getResources(),
                R.mipmap.ic_launcher_round);

        NotificationCompat.Builder notifiBuilder = new NotificationCompat.Builder(context)
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setAutoCancel(true)
                .setContentText("lalalalalala lalalalalal lalalalalalal lalalalaaa")
                .setSound(notificationSound)
                .setContentIntent(pendingIntent);

        Notification not = notifiBuilder
                .setContentTitle("The Big Notification")
                .setContentText(body)
                .setStyle(new NotificationCompat.BigPictureStyle(notifiBuilder)
                        .bigLargeIcon(icon))
                .build();

        NotificationManager notificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(123456 /*ID of notification*/, notifiBuilder.build());
    }