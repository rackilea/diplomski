public static void setNotification(Context context, boolean enabled) {
    NotificationManager manager =
        (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);

    if (enabled) {
        final RemoteViews rViews = new RemoteViews(context.getPackageName(),
                                                   R.layout.notification);

        final Intent intent = context.getPackageManager()
            .getLaunchIntentForPackage(context.getPackageName());

        if (intent != null) {
            PendingIntent pi = PendingIntent.getActivity(context,
                                                         0,
                                                         intent,
                                                         0);

            rViews.setOnClickPendingIntent(R.id.notification_button_1, pi); 
        }

        Notification.Builder builder = new Notification.Builder(context);
        builder.setContent(rViews)
            .setSmallIcon(R.drawable.ic_launcher)
            .setWhen(0)
            .setOngoing(true);

        manager.notify(0, builder.build());
    }
    else {
        manager.cancel(0);
    }
}