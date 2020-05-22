public void onClick(View v) {
        Intent i = new Intent(Settings.this, Start.class);
        startActivity(i);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // 10 minutes * 60000 milliseconds(1 minute)
                    Thread.sleep(10 * 60000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Intent intent = new Intent();
                PendingIntent pIntent = PendingIntent.getActivity(Settings.this, 0, intent, 0);
                Notification noti = new Notification.Builder(Settings.this)
                        .setTicker("TickerTitle")
                        .setContentTitle("Price-Tracker")
                        .setContentText("ContentText")
                        .setSmallIcon(R.mipmap.pw)
                        .setContentIntent(pIntent).getNotification();
                noti.flags = Notification.FLAG_AUTO_CANCEL;
                NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                nm.notify(0, noti);
            }
        }).start();
}