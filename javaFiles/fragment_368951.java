Timer timer;
TimerTask timerTask;

public static void startTimer(Context context) {
    timer = new Timer();
    initializeTimerTask(context);
    timer.schedule(timerTask, 5000);  //Time in miliSeconds
}

public static void stopTimer(){
    if(timer != null)
        timer.cancel();
    timer = null;
}

public static void initializeTimerTask(final Context context){
    timerTask = new TimerTask() {
        public void run() {
            handler.post(new Runnable() {
                public void run() {
                    Toast.makeText(context, "Check Network connection...", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}