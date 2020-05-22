new CountDownTimer(5000, 1000) {

     public void onTick(long millisUntilFinished) {
         textView2.setText("seconds remaining: " + millisUntilFinished / 1000);
     }

     public void onFinish() {
         textView1.setText("done!");
     }
  }.start();