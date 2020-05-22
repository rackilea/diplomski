Button btn=(Button) findViewById(R.id.sleepLock);
PowerManager.WakeLock wl; //This is before my oncreate
int stayAwake = 0; //This is before my oncreate

btn.setOnClickListener(new View.OnClickListener() {

    @Override
    public void onClick(View v) {
        PowerManager pm = (PowerManager) getSystemService (Context.POWER_SERVICE); 
        wl = pm.newWakeLock (PowerManager.FULL_WAKE_LOCK, "My Tag"); 
        if (stayAwake == 0) {
            btn.setBackgroundResource(R.drawable.awake);
            stayAwake = 1;
            wl.acquire();
        } else {
            btn.setBackgroundResource(R.drawable.sleep);
            stayAwake = 0;
            wl.release();
        }
    }
});