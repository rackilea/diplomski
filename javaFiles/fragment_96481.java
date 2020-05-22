try{
        Log.i(TAG, "In try block of notification");
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent, 0);
        Notification notification = new Notification.Builder(this)
        .setTicker("My Company")
        .setContentTitle("Welcome")
        .setContentText("Click here to see offers...")
        .setSmallIcon(R.drawable.icon)
        .setContentIntent(pIntent).getNotification();
        notification.flags=Notification.FLAG_AUTO_CANCEL;
        NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(0, notification);
    }catch(Exception e){
        Log.e(TAG, "In catch block of notification:"+e);
    }