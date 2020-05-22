public void method1() {
   withLock(new LockableMethod() {
       public void run() {
           /** your method1 code here **/
       }
   });
}

private void withLock(LockableMethod lockableMethod) {  
   LOCK.lock();
   try {
       lockableMethod.run();
   } finally {
       LOCK.unlock();
   }
}