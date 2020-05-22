registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Object result = intent.getExtras().get("searchResult");
            }
        }, new IntentFilter("myAction"));