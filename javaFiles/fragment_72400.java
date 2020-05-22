Intent intent = new Intent(this, YourClass.class);
intent.putExtra("NotiClick",true);
PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN) {
    Notification Noti;
    Noti = new Notification.Builder(this)
            .setContentTitle("YourTitle")
            .setContentText("YourDescription")
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentIntent(pIntent)
            .setAutoCancel(true).build();

    NotificationManager notificationManager =
            (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

    notificationManager.notify(0, Noti);
}