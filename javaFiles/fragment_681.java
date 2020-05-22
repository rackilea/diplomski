private void showNotification(String eventtext, Context ctx) {



    // Set the icon, scrolling text and timestamp
    Notification notification = new Notification(R.drawable.noti_icon,
            text, System.currentTimeMillis());

    // The PendingIntent to launch our activity if the user selects this
    // notification
    PendingIntent contentIntent = PendingIntent.getActivity(ctx, 0,
            new Intent(ctx, MainActivity.class), 0);

    // Set the info for the views that show in the notification panel.
    notification.setLatestEventInfo(ctx, "Title", eventtext,
            contentIntent);

    // Send the notification.
    mNotificationManager.notify("Title", 0, notification);
}