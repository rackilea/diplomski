new Thread(new Runnable(){
    public void run(){
        while(true){
            //Listen to the client if there is new time available
            //get new timer to a variable (here, newData)
            myTimer.setTimer(newData);
        }
    }
}).start();