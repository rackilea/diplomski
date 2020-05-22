private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {                                      
   SimpleThread mouseGrab = new MouseGrabThread(jTextField1, jTextField2); //This grabs mouse coords and updates two boxes in the UI.
   SimpleThread timer = new TimerThread(mouseGrab, jTextArea1, 10); //This counts down from 10 seconds and updates a status text box each second

   mouseGrab.start();
   timer.start();
}