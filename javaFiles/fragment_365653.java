Thread dt = (Thread)this.getServletContext().getAttribute("myDaemon");
if(dt != null){ 
     if (dt.isRunning()){  
         // Running so you can only check STOP command
         if (yourCommand == 'STOP'){
            dt.setRunning(false);
         }             
     }
     else {
         // Not Running so check START command
         if (yourCommand == 'START'){
            dt.start();
         }
     }
}
else{
    // First time
   // create exception handler for threads
ThreadExceptionHandler threadExceptionHandler = new ThreadExceptionHandler();
// start Daemon thread
Thread dThread = new Thread(new MyDaemon (), "Daemon");
dThread.setUncaughtExceptionHandler(threadExceptionHandler);
dThread.setDaemon(true);  
dThread.start();
// now save this dThread so servlet context
this.getServletContext().setAttribute("myDaemon", dThread); 
}