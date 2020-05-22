mouseGrab.start();
   timer.start();

   // Wait until countdown finishes
   while(timer.isAlive()) {}

   mouseGrab.setRunning(false);
}