NotificationReciever mReciever = new NotificationReciever();

this.registerReceiver(
                mReciever,new IntentFilter("PREVIOUS"));
this.registerReceiver(
                mReciever,new IntentFilter("PAUSE"));
this.registerReceiver(
                mReciever,new IntentFilter("NEXT"));