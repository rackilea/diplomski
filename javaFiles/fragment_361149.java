NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
Notification notification = new Notification(R.drawable.notification_icon, "Hello", System.currentTimeMillis());

Intent notificationIntent = new Intent(this, myclass.class);
notification.setLatestEventInfo(getApplicationContext(), "My notification", "Hello world!", notificationIntent, PendingIntent.getActivity(this, 0, notificationIntent, 0));

mNotificationManager.notify(1, notification);