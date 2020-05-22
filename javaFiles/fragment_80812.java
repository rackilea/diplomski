private IncomingReceiver receiver;
    public void onCreate(Bundle bOs){
        //other codes
        receiver = new IncomingReceiver(this);
    }
    @Override
    protected void onResume() {
        IntentFilter filter = new IntentFilter();
        filter.addAction(CUSTOM_INTENT);

        registerReceiver(receiver, filter);
        super.onResume();
    }

    @Override
    protected void onPause() {
        unregisterReceiver(receiver);
        super.onPause();
    }