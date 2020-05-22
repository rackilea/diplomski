SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    String formattedDate = "";
    formattedDate = sdf.format(new Date());

    RemoteViews contentView = new RemoteViews(getPackageName(), R.layout.notification);
    contentView.setImageViewResource(R.id.image, R.drawable.logo);
    contentView.setTextViewText(R.id.title, title);
    contentView.setTextViewText(R.id.text, message);
    contentView.setTextViewText(R.id.time, formattedDate);

    NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this)
            .setSmallIcon(R.drawable.home)
            .setContent(contentView);

    Notification notification = mBuilder.build();
    notification.flags |= Notification.FLAG_AUTO_CANCEL;
    notification.defaults |= Notification.DEFAULT_SOUND;
    notification.defaults |= Notification.DEFAULT_VIBRATE;
    NotificationManager notificationManager = (NotificationManager) MainActivity.this.getSystemService(Context.NOTIFICATION_SERVICE);
    int id = (int) System.currentTimeMillis();
    notificationManager.notify(id, notification);