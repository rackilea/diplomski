public void mostra(int Id) {

    notificationBuilder.setWhen(System.currentTimeMillis());
    notificationBuilder.setSmallIcon(R.drawable.ic_launcher);
    notificationBuilder.setDefaults(Notification.DEFAULT_SOUND | Notification.DEFAULT_LIGHTS );

    switch(Id)
    {
    case NOTIFICA1:
        notificationBuilder.setContentTitle("Text01");
        notificationBuilder.setContentText("Text01");
        mNotificationManager.notify(id, notificationBuilder.build());
        break;
    case NOTIFICA2:
        notificationBuilder.setContentTitle("Text02");
        notificationBuilder.setContentText("Text02");
        mNotificationManager.notify(id, notificationBuilder.build());
        break;
    }
}