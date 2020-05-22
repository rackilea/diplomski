textMsg.post( new Runnable(){

     public void run(){
            doProcessing();
            testMesg.setText("bla");
            testMsg.postDelayed(this,(1000*10));
     }
};