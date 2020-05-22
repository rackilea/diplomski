PhoneCallReceiver phoneCallReceiver=new PhoneCallReceiver(){
    @Override
    public void onReceive(Context context, Intent intent) {

        pauseWorkout();

    }
};