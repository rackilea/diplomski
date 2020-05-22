private final BroadcastReceiver CallReceiver = new BroadcastReceiver() {
    public void onReceive(Context context, Intent intent) {
        AudioManager amanager=(AudioManager)getSystemService(Context.AUDIO_SERVICE);
        amanager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);

        String state = intent.getStringExtra(TelephonyManager.EXTRA_STATE);

        if (TelephonyManager.EXTRA_STATE_IDLE.equals(state))
        {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            amanager.setRingerMode(0);  //Ringer Silent
        }
        if (TelephonyManager.EXTRA_STATE_OFFHOOK.equals(state))
        {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            amanager.setRingerMode(0);  ////Ringer Silent
        }
        if (TelephonyManager.EXTRA_STATE_RINGING.equals(state))
        {
            amanager.setRingerMode(2);  //Ringer ON
        }
    }
       };