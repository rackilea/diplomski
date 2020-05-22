Handler myHandler;

Runnable runnable = new Runnable(){

    @Override
    public void run() {

        if(isRunning) {

           mNotificationBuilder.setContentTitle("Text").setContentText("This value here updates every 1 sec").setSmallIcon(R.drawable.ic_launcher);

           mNotifyManager.notify(notificationID, mNotificationBuilder.build());

           myHandler.postDelayed(runnable, 1000);
        }
    }

};

...