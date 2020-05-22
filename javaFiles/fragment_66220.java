private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {                                      
   SimpleThread timer = new TimerThread(jTextArea1, 10); //This counts down from 10 seconds and updates a status text box each second
   SimpleThread mouseGrab = new MouseGrabThread(jTextField1, jTextField2); //This grabs mouse coords and updates two boxes in the UI.

   mouseGrab.start();
   timer.start();

   // Wait until countdown finishes
   while(timer.isAlive()) {}

   mouseGrab.stop();
}