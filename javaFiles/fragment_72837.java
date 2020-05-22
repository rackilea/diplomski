final CountDownTimer timer = new CountDownTimer(millisInFuture,countDownInterval){......}
timer.start();

bNext.setOnClickListener(new View.OnClickListener() {                       

   @Override                                                               
   public void onClick(View v) {                                                   
     timer.cancel();
           .........
   }                                                                       

});