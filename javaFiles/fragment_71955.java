public String jmxShutdown() {
     new Thread(new Runnable() {
         public void run() {
             try {
                Thread.sleep(100);
             } catch (InterruptedException e) {
                // ignored
             }
             System.exit(1);
         }
     });
     return "Shutting down";
 }