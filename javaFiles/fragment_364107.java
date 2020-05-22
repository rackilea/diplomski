public A() {
      broadcastReceiver = new BroadcastReceiver() {
          @Override
          public void onReceive(Context context, Intent intent) {
              if(intent.getAction().equals("SERVICE_FINISHED")) {
                //do stuff}
              }
          }
      };
      LocalBroadcastManager.getInstance(this).registerReceiver(broadcastReceiver, new IntentFilter("SERVICE_FINISHED"));
   }