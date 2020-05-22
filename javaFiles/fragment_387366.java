public class checkTimer extends TimerTask{

   int counter = 0;


   public  void startTimer()
   {
     Timer timer = new Timer();
     timer.schedule(this, 500, 500);
   }


    @Override
    public void run() {
       counter++;
        System.out.println(counter); // use logCat to see
    }
}