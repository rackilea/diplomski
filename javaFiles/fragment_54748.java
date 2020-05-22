public boolean onNotificationClicked(final FlurryMessage flurryMessage) {
sEnableMessagingListener = true;
new android.os.Handler().postDelayed(
        new Runnable() {
            public void run() {
                Log.i("tag", "This'll run 300 milliseconds later");
                Log.d("Click0012","ff11"+ "ggg"+ sReactApplicationContext + "ddd" + flurryMessage);

                Log.d("message001","ff"+flag +"999"+ sReactApplicationContext+"ff"+ sEnableMessagingListener);
                if (sEnableMessagingListener  && (sReactApplicationContext != null)) {
                    Log.d("Clicked002","ff"+flurryMessage);
                     sendEvent(EventType.NotificationClicked, flurryMessage, true);
                }
            }
        },
        900);



return false;