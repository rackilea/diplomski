void displayUnsyncList() {
       synchronized (unsync) {
       ListIterator<String> itr = unsync.listIterator();
       while (itr.hasNext()) {
           String x = itr.next();
           System.out.println("Thread " + 
                              Thread.currentThread().getName() + 
                              " is displaying name : " + x);
       } 
   }