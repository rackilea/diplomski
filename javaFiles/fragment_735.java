private Handler mHandler = new Handler() {
 @Override
 public void handleMessage(Message msg) {
    time = new Time();
    time.setToNow();

    timeString = time.toString();
    changeTime = Parser(timeString); 
    timer.setText(changeTime);  
 }
};