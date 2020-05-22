public void DonwloadDone()
        {
            mNotifyManager.cancel(id);
            mNotifyManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            build = new NotificationCompat.Builder(getBaseContext());
            build.setContentTitle("Download")
                    .setContentText("Complete")
                    .setSmallIcon(R.drawable.ic_launcher_foreground);
            Notification notification = build.build();
            mNotifyManager.notify(id, notification);
            sendMyBroadCast("Complete",fx.getPath());

        }