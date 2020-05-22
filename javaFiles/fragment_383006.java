public void onCreate(){
  new CountDownTimer(5000, 1000) {

     public void onTick(long millisUntilFinished) {
        Log.e("isClicked", String.valueOf(isClicked));
     }

     public void onFinish() {
        if(!isClicked) throw null;
     }
  }.start();
}