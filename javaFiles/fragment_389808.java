mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                if (mp.isPlaying()){
                        //Show notification if music have started play
                        showNotif(context, CHANNEL_ID)
                }
            }
        });


     public void showNotif(Context context, String CHANNEL_ID){
            NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context, CHANNEL_ID)
                    .setSmallIcon(R.drawable.ic_bubble_notif)
                    .setContentTitle("New Item Remind!")
                    .setAutoCancel(true)
                    .setContentIntent(pendingIntent)
                    .setContentText(context.getString(R.string.notif_msg, reminder.getNumberOfItems()))
                    .setPriority(NotificationCompat.PRIORITY_HIGH);

            createNotificationChannel(context);

            NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);

            // notificationId is a unique int for each notification that you must define
            notificationManager.notify(0, mBuilder.build());
        }


        private void createNotificationChannel(Context context) {
            // Create the NotificationChannel, but only on API 26+ because
            // the NotificationChannel class is new and not in the support library
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                CharSequence name = "CHANEL_NAME";
                String description = "CHANNEL_DESC";
                int importance = NotificationManager.IMPORTANCE_DEFAULT;
                NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
                channel.setDescription(description);
                // Register the channel with the system; you can't change the importance
                // or other notification behaviors after this
                NotificationManager notificationManager = context.getSystemService(NotificationManager.class);
                notificationManager.createNotificationChannel(channel);
            }
        }