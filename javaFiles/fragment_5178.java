@Override
    protected void onHandleIntent(Intent intent) {
        Bundle extras = intent.getExtras();
        GoogleCloudMessaging gcm = GoogleCloudMessaging.getInstance(this);
        // The getMessageType() intent parameter must be the intent you received
        // in your BroadcastReceiver.
        String messageType = gcm.getMessageType(intent);

        if (!extras.isEmpty()) {  // has effect of unparcelling Bundle
            /*
             * Filter messages based on message type. Since it is likely that GCM will be
             * extended in the future with new message types, just ignore any message types you're
             * not interested in, or that you don't recognize.
             */
            if (GoogleCloudMessaging.MESSAGE_TYPE_SEND_ERROR.equals(messageType)) {
                Log.i(Consts.TAG, "onHandleIntent: message error");
            } else if (GoogleCloudMessaging.MESSAGE_TYPE_DELETED.equals(messageType)) {              
              Log.i(Consts.TAG, "onHandleIntent: message deleted");
        // If it's a regular GCM message, do some work.
        } else if (GoogleCloudMessaging.MESSAGE_TYPE_MESSAGE.equals(messageType)) {
            String subId = intent.getStringExtra(GCM_KEY_SUBID);
            Log.i(Consts.TAG, "onHandleIntent: subId: " + subId);
            String[] tokens = subId.split(":");
            String typeId = tokens[1];

            // dispatch message
            if (GCM_TYPEID_QUERY.equals(typeId)) {
                Intent messageIntent = new Intent(BROADCAST_ON_MESSAGE);
                messageIntent.putExtras(intent);
                messageIntent.putExtra("token", tokens[2]);
                boolean isReceived = LocalBroadcastManager.getInstance(this).sendBroadcast(messageIntent);
                //Check if the broadcast has been handled, if not show the notification.
                if (!isReceived) {
                    Log.i(Consts.TAG, "A message has been recieved but no broadcast was handled.");
                    generateNotification(this, intent, tokens[2]);
                } else {
                    Log.i(Consts.TAG, "A message has been recieved, broadcasted and handled.");
                }
            }
        }
    }
    // Release the wake lock provided by the WakefulBroadcastReceiver.
    GCMBroadcastReceiver.completeWakefulIntent(intent);
}

public static void generateNotification(Context context, Intent intent, String message) {
    //Event keys
    HashMap data = new HashMap();
    for (String key : intent.getExtras().keySet()) {
        Log.d(Consts.TAG, "Message key: " + key + " value: " + intent.getExtras().getString(key));
        String eventKey = key.startsWith("data.") ? key.substring(5) : key;
        data.put(eventKey, intent.getExtras().getString(key));
    }

    CharSequence contentTitle = (CharSequence) data.get("updatedBy");
    if (contentTitle == null) contentTitle = "New Message";

    CharSequence contentText = (CharSequence) data.get("message");
    if (contentText == null) contentText = "";

    CharSequence userId = (CharSequence) data.get("updatedBy");
    Bitmap iconBitmap = getUserIcon(context, userId.toString());
    if (iconBitmap == null) iconBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_launcher);

    // Creates an Intent for the Activity
    Intent resultIntent = new Intent(context, GuestbookActivity.class);
    // The stack builder object will contain an artificial back stack for the started Activity.
    // This ensures that navigating backward from the Activity leads out of
    // your application to the Home screen.
    TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
    // Adds the back stack for the Intent (but not the Intent itself)
    stackBuilder.addParentStack(IntroductionActivity.class);
    // Adds the Intent that starts the Activity to the top of the stack
    stackBuilder.addNextIntent(resultIntent);
    PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);


    Notification.Builder mBuilder = new Notification.Builder(context);
    mBuilder.setContentIntent(resultPendingIntent);

    Notification notification = mBuilder
    .setContentTitle(contentTitle)
    .setContentText(contentText)
    .setSmallIcon(R.drawable.notification_icon)
    .setLargeIcon(iconBitmap)
    .setTicker(contentTitle + ": " + contentText)
    .setWhen(System.currentTimeMillis())
    .setAutoCancel(true)
    .build();

    ///Get the notification ID, /it allows to update the notification later on.
    int notifyID = 1;
    String contentID = (String) data.get("id");
    if(contentID != null) {
        notifyID = Integer.parseInt(contentID);
    }

    NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
    mNotificationManager.notify(notifyID, notification);
}