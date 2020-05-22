private BroadcastReceiver receiver = new BroadcastReceiver(){
    @Override
    public void onReceive(Context arg0, Intent intent) {

    int level = intent.getIntExtra("level", 0);
    Log.e("test", String.valueOf(level) + "%");

     }
};