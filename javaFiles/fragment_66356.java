public void run() {
      while(true) {

         //do everything you need
         try {
            // thread to sleep for 1000 milliseconds
            Thread.sleep(1000);
         } catch (Exception e) {
              System.out.println(e);
           }
      }
   }