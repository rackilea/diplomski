NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
         // Create your notification
         int icon = R.drawable.ic_launcher;
         CharSequence tickerText = " message";
         Intent notificationIntent
         long when = System
                 .currentTimeMillis();
         Notification notification = new Notification(
                 icon, tickerText,
                 when);
         notificationIntent = new Intent(context,
                    YourActivity.class);
         Context context = getApplicationContext();
         CharSequence contentTitle = last_notifs_array[0][2];
         CharSequence contentText = "New Message";
         PendingIntent pIntent = PendingIntent
                 .getActivity(
                         notifService.this,
                         0, notificationIntent,
                         0);
         notification
                 .setLatestEventInfo(
                         context,
                         contentTitle,
                         contentText,
                         pIntent);
         // Send the notification
         nm.notify(HELLO_ID,
                 notification);