ReentrantLock lock = new ReentrantLock();
         public void  wish(String name)
         {
             //using locks
             lock.lock();
             try {
                 for (int i = 0; i < 10; i++) {
                     System.out.print("Good Morning : ");
                     try {
                         Thread.sleep(2000);
                     } catch (InterruptedException e) {
                         System.out.println("I got intruppted");
                     }
                     System.out.println(name);
                 } 
             } finally {
                 lock.unlock();
             }

         }