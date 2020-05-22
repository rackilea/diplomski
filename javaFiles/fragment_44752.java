@Override
    public void run() {
        super.run(); // <-- This call runs the Looper loop and doesn't complete!!
        try{
            handler = new WorkerHandler(getLooper());
        }catch(Exception e){
            e.printStackTrace();
        }               
    }