class painter implements Runnable {

   @Override
   public void run() {

      // the Swing call below must be queued onto the Swing event thread
      SwingUtilities.invokeLater(new Runnable(){
         @Override
         public void run() {
            while(cond..){
               // OK To make Swing method calls here
               length_of_line++;
               yourPanel.repaint();
            }
         }
      });
      try {
         Thread.sleep(1000);
      } catch (InterruptedException e) {
        // ....
      }
   }
}