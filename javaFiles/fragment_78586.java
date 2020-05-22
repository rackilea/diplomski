private void btnGuess1ActionPerformed(java.awt.event.ActionEvent evt) {    
    timer.cancel();
    TimerTask task = new TimerTask(){
       private int i = 0;
       public void run(){
       if (i <= 20){
         lblTimer.setText("" + i++);
      }
    }
};
timer = new Timer();
timer.scheduleAtFixedRate(task, 0, 1000);