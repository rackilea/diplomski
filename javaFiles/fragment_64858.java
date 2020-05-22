private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
    @Override
    public void onReceive(Context context, Intent intent) {
        String action= intent.getStringExtra("action");
        if(action.equals("close")) {
            Pitanja_cigle.this.finish();
        }
    }
};

@Override
public void onCreate(Bundle savedInstanceState) {
    LocalBroadcastManager.getInstance(this).registerReceiver(broadcastReceiver, new IntentFilter("Pitanja_cigle"));
}