//-------------------Part 1 of AddCircleTimer------------------------
     //Declare the timerAddCircle
     timerAddCircle = new Timer();
     timerAddCircle.schedule(new TimerTask() {
         @Override
         public void run() {
             TimerMethodAddCircle();
         }
     }, 1000, 1000);

 //-------------------Part 2 of AddCircleTimer------------------------
private void TimerMethodAddCircle()
{
    //This method is called directly by the timer and runs in the same thread as the timer.
    //We call the method that will work with the UI through the runOnUiThread method.
    this.runOnUiThread(Timer_Add);
}

private Runnable Timer_Add = new Runnable() {
    public void run() {
    //This method runs in the same thread as the UI.               
    //Do something to the UI thread here
         Drawing.addCircle();
         d.invalidate();
    }
};
//-------------------END Part 2 of AddCircleTimer------------------------