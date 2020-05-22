public class MyUpdater implements Runnable {

   MediaPlayer mp;
   SeekBar sb;

   public MyUpdater(MediaPlayer mp, SeekBar sb) {
        this.mp = mp;
        this.sb = sb;
   }

   @Override
   public void run(){
     int totalDuration = mp.getDuration();
     int currentPosition = mp.getCurrentPosition();
     if (currentPosition<totalDuration) {
        sb.removeCallbacks(this);
        return;
     }   
     sb.setProgress(currentPosition);
     sb.postDelayed(this, 500);
  }  
}