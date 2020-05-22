Stopwatch stopwatch = Stopwatch.createStarted();

void startThreadUpdateTimer(){}
    Timer T = new Timer();
    T.scheduleAtFixedRate(new TimerTask() {
        @Override
        public void run() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    String workingTime = "Your effort is " + sw.toString() + 
                         " till now for the day";                        
                }
            });
        }
    }, 1000, 1000);
}

public void pause(){
    if(stopwatch.isRunning()){
        stopwatch.stop();
    }
}

public void resume(){
    if(!stopwatch.isRunning()){
        stopwatch.start();
    }
}