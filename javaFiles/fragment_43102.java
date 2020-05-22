@Override
public int onStartCommand(Intent intent, int flags, int startId) {

    final NotificationManager notificationManager = (NotificationManager) 
            getSystemService(NOTIFICATION_SERVICE);

    // Create Notifcation
    final Notification notification = new Notification(R.drawable.ic_launcher,
        "A new notification", System.currentTimeMillis());

    // Cancel the notification after its selected
    notification.flags |= Notification.FLAG_AUTO_CANCEL;
    //
    notification.number += 1;

    // Specify the called Activity
    Intent intent2 = new Intent(this, NotificationReceiver.class);

    Toast.makeText(getApplicationContext(), "Service is started!", 1)
            .show();

    PendingIntent activity = PendingIntent.getActivity(this, 0, intent2, 0);
    notification.setLatestEventInfo(this, "This is the title",
        "This is the text", activity);


    myHandler = new Handler();

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            int i = 0;

            while (true) {
                final int x = i++;

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }

                myHandler.post(new Runnable() {

                    @Override
                    public void run() {

                        try {
                            Toast.makeText(getApplicationContext(),
                                    "Hello!" + String.valueOf(x),
                                    3).show();

                            if(x == 100)
                                notificationManager.notify(0, notification);
                            Thread.sleep(1);

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        }
    };
    new Thread(runnable).start();