public void createNotification(View view) {

  showNotification("hello");
} 

public void showNotification(String msg)
{
  Intent intent = new Intent(this, Home.class);
    PendingIntent pIntent = PendingIntent.getActivity(this, (int) System.currentTimeMillis(), intent, 0);

    // Build notification
    // Actions are just fake
    Notification noti = new Notification.Builder(this)
            .setContentTitle("title")
            .setContentText(msg).setSmallIcon(R.drawable.original_logo)
            .setContentIntent(pIntent)
            .addAction(R.drawable.original_logo, "Call", pIntent)
            .addAction(R.drawable.original_logo, "More", pIntent)
            .addAction(R.drawable.original_logo, "And more", pIntent).build();
    NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    // hide the notification after its selected
    noti.flags |= Notification.FLAG_AUTO_CANCEL;

    notificationManager.notify(0, noti);

}