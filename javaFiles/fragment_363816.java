public class MyClass
{
    private boolean isMusicPlaying = false;

    public void someFunctionWhichStartsMusic()
    {
        //start the music

        isMusicPlaying = true;
    }

    public void level_one(View view){

        mp3 = MediaPlayer.create(this, R.raw.alpha_12);

        PhoneStateListener phoneStateListener = new PhoneStateListener() {
            @Override
            public void onCallStateChanged(int state, String incomingNumber) {
                if (state == TelephonyManager.CALL_STATE_RINGING)
                {
                    mp3.pause();
                }
                else if(state == TelephonyManager.CALL_STATE_IDLE
                          && isMusicPlaying) // pay attention to this!
                {
                    mp3.start();
                }
                else if(state == TelephonyManager.CALL_STATE_OFFHOOK)
                {
                    mp3.pause();
                }
                super.onCallStateChanged(state, incomingNumber);
            }
        };
        TelephonyManager mgr = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
        if(mgr != null) {
            mgr.listen(phoneStateListener, PhoneStateListener.LISTEN_CALL_STATE);
        }
    }
}