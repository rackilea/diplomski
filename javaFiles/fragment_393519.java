LocalBroadcastManager.getInstance(this).registerReceiver(
                new NotificationReciever(),new IntentFilter("PREVIOUS"));
        LocalBroadcastManager.getInstance(this).registerReceiver(
                new NotificationReciever(),new IntentFilter("PAUSE"));
        LocalBroadcastManager.getInstance(this).registerReceiver(
                new NotificationReciever(),new IntentFilter("NEXT"));