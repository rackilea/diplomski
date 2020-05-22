static final Object boxingQLock=new Object();

synchronized (boxingQLock) {
   while ( boxingQ does not satisfy the condition) {
      boxingQLock.wait(); 
   } 
   // when you come here, boxingQ satisfies the condition, and you are
   // holding a lock on it
}