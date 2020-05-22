private BroadcastReceiver createBroadcastReceiver() {
    return new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            weight = intent.getStringExtra("Output");
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    //what you want to happen
                }
            });
        }
    };
}// end createBroadcastReceiver