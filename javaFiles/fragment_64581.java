CountDownTimer timer1 = new CountDownTimer(30000, 1000) {

 public void onTick(long millisUntilFinished) {
//do whatever you need here, this gets called every 1000 milliseconds (the 2nd parameter
of the constructor, the first is total time in ms
 }

 public void onFinish() {
    CountDownTimer timer2 = new CountDownTimer(5000, 1000) {
        //same logic
        };
        timer2.start();
    }
};