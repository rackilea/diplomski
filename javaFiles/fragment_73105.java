Thread threadRecord = new Thread(new Runnable() { 

     private final Recorder target = recordIn;
    private final Scanner scanr= scanIn;     
    @Override
    public void run() {
        //if movement is noticed compared to the last frame save 
        recordIn.startRecording();
        while(true){
            synchronized(target ){
                while(target.hasMore()){

                   synchronized(scanr)
                   {
                       while(!target.currentImage().equals(scanr.getLatestImage())
                       {
                           target.recordMore();    
                           scanr.wait();
                       }
                   }
                 }
            }
        }
     }
}


 }); Thread threadScan = new Thread(new Runnable() { private final Recorder targetsRecorder = recordIn; private final Scanner target = scanIn; @Override public void run() { //do stuff here synchronized(target){ target.wait(); while(true) { while(!targetsRecorder.doneRecording() && targetsRecorder.currentImage().equals(scanIn.getLastImage())) target.wait();

                 if(targetsRecorder.doneRecording())
                    return;

                scanIn.scanCurrentImage(targetsRecorder);
             }
        }       
}


 } });

 threadScan.start(); threadRecord.start();