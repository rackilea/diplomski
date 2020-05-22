Timer findQuery = new Timer();
...
public void keyStrokeDetected(..) {
   findQuery.cancel();
   findQuery = new Timer();
   String text = widget.getEnteredText();
   final TimerTask task = new TimerTask() {
      public void run() {
         ...query Lucene Index for matches
      }
   };
   findQuery.schedule(task, 350); //350 ms delay
}