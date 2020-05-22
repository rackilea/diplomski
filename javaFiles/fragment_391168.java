Intent playPauseIntent = new Intent(MyApp.mainActivity, NotificationService.class);
playPauseIntent.putExtra("do_action", "play");
contentView.setOnClickPendingIntent(R.id.notifPlayPauseImageView, PendingIntent.getService(MyApp.mainActivity, 0, playPauseIntent, PendingIntent.FLAG_UPDATE_CURRENT));            

Intent nextRadioIntent = new Intent(MyApp.mainActivity, NotificationService.class);
nextRadioIntent.putExtra("do_action", "next");
contentView.setOnClickPendingIntent(R.id.notifNextImageView, PendingIntent.getService(MyApp.mainActivity, 1, nextRadioIntent, PendingIntent.FLAG_UPDATE_CURRENT));

Intent previousRadioIntent = new Intent(MyApp.mainActivity, NotificationService.class);
previousRadioIntent.putExtra("do_action", "previous");
contentView.setOnClickPendingIntent(R.id.notifPreviousImageView, PendingIntent.getService(MyApp.mainActivity, 2, previousRadioIntent, PendingIntent.FLAG_UPDATE_CURRENT));

notification.contentView = contentView;
mNotificationManager.notify(1, notification);