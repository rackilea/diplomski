private final BroadcastReceiver mHandleMessageReceiver = new BroadcastReceiver(){
        @Override
        public void onReceive(Context context, Intent intent) {
            //Get all your music data from the intent
            String position = intent.getStringExtra("pos");
            ...
        }
 };