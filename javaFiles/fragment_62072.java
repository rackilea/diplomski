final boolean shouldRun = true;

Thread t = new Thread(){
    public void run(){
        while (shouldRun){
            //do what ever you need
            try{
                Thread.sleep(100); //sleep for 100ms
            } catch (Exception e) {

            }
         }
    }
 };

shouldRun = true;
t.start();