NotificationManager nm = (NotificationManager) ctx
            .getSystemService(Context.NOTIFICATION_SERVICE);

    Resources res = ctx.getResources();

    // Creates an explicit intent for an Activity in your app
    Intent resultIntent = new Intent(this, ResultActivity.class);
    String pass = text.getText().toString();
    resultIntent.setData(new Uri.Builder().scheme("data")
            .appendQueryParameter("text", "my text").build());
    resultIntent.putExtra("title", pass);
    resultIntent.putExtra("uid", i);

    TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
    // Adds the back stack for the Intent (but not the Intent itself)
    stackBuilder.addParentStack(ResultActivity.class);
    // Adds the Intent that starts the Activity to the top of the stack
    stackBuilder.addNextIntent(resultIntent);
    PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0,
            PendingIntent.FLAG_UPDATE_CURRENT);

    NotificationCompat.Builder builder = new NotificationCompat.Builder(ctx);
    builder.setSmallIcon(R.drawable.ic_launcher)
            .setLargeIcon(
                    BitmapFactory.decodeResource(res,
                            R.drawable.ic_launcher))
            .setTicker("Remember to " + text.getText())
            .setWhen(System.currentTimeMillis()).setAutoCancel(true)
            .setContentTitle(text.getText())
            .setContentIntent(resultPendingIntent);

    Notification n = builder.build();
    n.flags = Notification.FLAG_NO_CLEAR;
    nm.notify(i++, n);

    text.setText(null);