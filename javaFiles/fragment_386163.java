public class CounterClass extends CountDownTimer {  
          public CounterClass(long millisInFuture, long countDownInterval) {  
               super(millisInFuture, countDownInterval);  
          }  
          @Override  // when timer is finished
         public void onFinish() {  
           System.out.println("Completed.");  
         }  
          @Override  // on every tick of the timer
          public void onTick(long millisUntilFinished) {  
                long millis = millisUntilFinished;  
                 String hms = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(millis),  
                     TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),  
                     TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));  
                 System.out.println(hms);  

          }  
     }  
}