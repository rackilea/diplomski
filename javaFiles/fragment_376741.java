public void sendData( ){
    for(databaseList().length){
        //send data
        if(isFailure){
            int dealyTime = 10; //in seconds
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    sendData();
                }
            },dealyTime*1000);
            break;
        }
    }
}