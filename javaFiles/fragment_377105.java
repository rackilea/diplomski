//Pseudo Code
public doLongRuningOperation(final Object ... objects){
  final Thread longRunning = new Thread(){
    public void run(){
       update("this");
       sleep(1000); //Pause/do something etc...
       update("should");
       sleep(1000);
       update("update");
       System.err.println("completed");
    }
  };
  longRunning.start(); //Start this process
}
//Rejoin the UI Thread and update it...
public void update(final String text){
   //reference to label 'lbl'
   Platform.runLater(new Runnable(){
     lbl.setText(text);
   });
}