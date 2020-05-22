private final BroadcastReceiver receiver = new BroadcastReceiver() {
       @SuppressWarnings("deprecation")
    @Override
       public void onReceive(final Context context, Intent intent) {

          String action = intent.getAction();
          if(action.equals(Intent.ACTION_POWER_CONNECTED)) {
                    // Do something when power connected
             //save time in proper format in preference or anywhere
                }
                else if(action.equals(Intent.ACTION_POWER_DISCONNECTED)) {
                    // Do something when power disconnected
                    //take the time differene between connted time that
                    // was saved and current time and dispay it

                      tv.setText(time_differenece);
                }

          }

    };
IntentFilter filter = new IntentFilter();
  filter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
  filter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
  registerReceiver(receiver, filter);