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