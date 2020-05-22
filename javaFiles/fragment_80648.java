volatile boolean runServices = true;
volatile boolean linuxCmd = true;
volatile boolean insertLog = true;
int SLEEP_TIME = 100;//Configurable. 
Thread thread1 = new Thread() {
   public void run() {
       while (runServices)
       {
           try
           {
                Runjar.Runservices();
                Thread.sleep(SLEEP_TIME);//So that other thread also get the chance to execute.
           }
           catch (Exception ex)
           {
               ex.printStackTrace();
           }

       }    
   }
};
Thread thread2 = new Thread() {
   public void run() {
       while (linuxCmd)
       {
           try
           {
                ControllerApplication.linuxCmd();
                Thread.sleep(SLEEP_TIME);//So that other thread also get the chance to execute.
           }
           catch (Exception ex)
           {
               ex.printStackTrace();
           }
       }
   }
};
Thread thread3 = new Thread() {
   public void run() {
       while (insertLog)
       {
           try
           {
                Utils.insertLog();
                Thread.sleep(SLEEP_TIME);//So that other thread also get the chance to execute.
           }
           catch (Exception ex)
           {
               ex.printStackTrace();
           }
       }

   }
};
thread1.start();
thread2.start();
thread3.start();