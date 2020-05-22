public BroadcastReceiver receiver = new BroadcastReceiver() {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e(tag, "SMS Received.");
        // Intent i = getIntent();
        Bundle b = intent.getBundleExtra("SMS");
        // String bun = b.getString("MyData");
        Log.i(tag, "Bundle:  " + b);
        String str = intent.getStringExtra("data");

        parseSMSData(str);
    }
};