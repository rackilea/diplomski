public class MyCount extends CountDownTimer {
     public MyCount(long millisInFuture, long countDownInterval) {
         super(millisInFuture, countDownInterval);
     }

     public void onFinish() {
         finish();
     }

     public void onTick(long millisUntilFinished) {
         vreme.setText("" + formatTime(millisUntilFinished));
     }
}
MyCount brojacVremena = new MyCount(timeCount, 1000);