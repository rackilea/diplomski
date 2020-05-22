BroadcastReceiver rec = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
            //all events will be received here
            //get message
            String message = intent.getStringExtra("message");
        }
    };
    LocalBroadcastManager.getInstance(this).registerReceiver(rec, new IntentFilter("event"));