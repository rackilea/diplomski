RemoteInput remoteInput = new RemoteInput.Builder(KEY_TEXT_REPLY)
                .setLabel(replyLabel)
                .build();

    PendingIntent resultPendingIntent =
                    stackBuilder.getPendingIntent(
                            0,
                            PendingIntent.FLAG_UPDATE_CURRENT
                    );

            // Add to your action, enabling Direct Reply for it
            NotificationCompat.Action action =
                    new NotificationCompat.Action.Builder(R.drawable.ic_stat_social_notifications_on, replyLabel, resultPendingIntent)
                            .addRemoteInput(remoteInput)
                            .setAllowGeneratedReplies(true)
                            .build();

            NotificationCompat.Builder mBuilder =
                    new NotificationCompat.Builder(this)
                            .addAction(action)
                            .setAutoCancel(true)
                            .setSmallIcon(R.drawable.ic_stat_social_notifications_on)
                            .setContentTitle("DevDeeds Says")
                            .setContentText("Do you like my tutorials ?");

            mBuilder.setContentIntent(resultPendingIntent);
            NotificationManager mNotificationManager =
                    (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

            //Show it
            mNotificationManager.notify(mRequestCode, mBuilder.build());