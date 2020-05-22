try {
   SwingUtilities.invokeAndWait( new Runnable() {
     public void run() {
//update state of the progress bar here
     }
   });
 } catch (InterruptedException e) {
 } catch (InvocationTargetException e) { }