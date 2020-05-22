Recorder recordIn= new Recorder();
Scanner scanIn= new Scanner();
Thread threadRecord = new Thread(new Runnable() { 

     private final Recorder target = recordIn;
    @Override
    public void run() {
    //do stuff in here
    }


 }); Thread threadScan = new Thread(new Runnable() { private final Recorder targetsRecorder = recordIn; private final Scanner target = scanIn; @Override public void run() { //do stuff here }

 });

 threadRecords.start(); threadScan.start();