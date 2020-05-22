public class OurNotification {


public void createNotification(Context context, String title, String msg, String other) {
NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context)
        .setSmallIcon(R.drawable.notification)
        .setContentTitle(title)
        .setContentText(msg);

// Creates an explicit intent for an Activity in your app
Intent resultIntent = new Intent(context, Menu.class);

// add so it removes
mBuilder.setAutoCancel(true);

//add vibrate and sound only use if you have the correct permissions in manifest or it will crash
//  long[] vibrate = {0,100,200,300};
//    mBuilder.setVibrate(vibrate);
mBuilder.setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION));      
mBuilder.setDefaults(Notification.DEFAULT_LIGHTS);
mBuilder.setOnlyAlertOnce(true);

if (other != null) {
    NotificationCompat.BigTextStyle bigStyle =
        new NotificationCompat.BigTextStyle();
    // Sets a title for the Inbox style big view
    bigStyle.setBigContentTitle(other);
    // Moves the big view style object into the notification object.
    mBuilder.setStyle(bigStyle);
}

// The stack builder object will contain an artificial back stack for the
// started Activity.
// This ensures that navigating backward from the Activity leads out of
// your application to the Home screen.
TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
// Adds the back stack for the Intent (but not the Intent itself)
stackBuilder.addParentStack(Menu.class);
// Adds the Intent that starts the Activity to the top of the stack
stackBuilder.addNextIntent(resultIntent);
PendingIntent resultPendingIntent =
        stackBuilder.getPendingIntent(
            0,
            PendingIntent.FLAG_UPDATE_CURRENT
        );
mBuilder.setContentIntent(resultPendingIntent);
NotificationManager mNotificationManager =
    (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
// mId allows you to update the notification later on.
mNotificationManager.notify(200, mBuilder.build());
}
}