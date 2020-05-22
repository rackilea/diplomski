class MyRunnable implements Runnable{

      private String result = "";
      private volatile boolean done = false;

      public synchronized void run(){
           while(!done){
                try{
                     Thread.sleep(1000);
                } catch (InterruptedException e) {
                     e.printStackTrace();
                }
                result = result + "A";
           }
    }

    public synchronized String getResult(){
         return result;
    }

    public void done(){
         done = true;
    }
 }