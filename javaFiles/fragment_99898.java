public static void sendNotification(Context context, String info){
        NotificationCompat.Builder notifyBuilder = new NotificationCompat.Builder(context);
//title notifications
notifyBuilder.setContentTitle(context.getString(R.string.app_name));
//small icon
notifyBuilder.setSmallIcon(R.drawable.ic_launcher);
//set contentText
notifyBuilder.setContentText(info);
notifyBuilder.setVibrate(new long[]{100, 200, 100, 500});       notifyBuilder.setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION));
//setAutoCancel
notifyBuilder.setAutoCancel(true);

getNotificationManager(context).notify(0, notifyBuilder.build());
}

public final static NotificationManager getNotificationManager(Context context) {
return (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
}