public static final String ACTION_BUTTON_SHARE = "ACTION_BUTTON_SHARE";
public static final String ACTION_BUTTON_REFRESH = "ACTION_BUTTON_REFRESH";

Intent refreshIntent = new Intent(context, ExampleAppWidget.class)
            .setAction(ACTION_BUTTON_REFRESH);
PendingIntent refreshPI = PendingIntent.getBroadcast(context, 0, refreshIntent,
            PendingIntent.FLAG_UPDATE_CURRENT);
remoteViews.setOnClickPendingIntent(R.id.refresh_button, refreshPI);

Intent shareIntent = new Intent(context, ExampleAppWidget.class)
            .setAction(ACTION_BUTTON_SHARE);
PendingIntent sharePI = PendingIntent.getBroadcast(context, 0, shareIntent,
            PendingIntent.FLAG_UPDATE_CURRENT);
remoteViews.setOnClickPendingIntent(R.id.share_button, sharePI);