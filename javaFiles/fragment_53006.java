Handler handler = new Handler();
Runnable alarmTest = new Runnable() {
    @Override
    public void run() {
        Log.i(LOG_TAG, String.valueOf(sendAlarm));
        handler.post(alarmTest, 5000); //wait 5 sec and run again
        //you can stop from outside
    }
};