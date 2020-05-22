while(!condition.compareAndSet(false,true));
try {
   //Only one thread can get here at a time...
 }finally{
     condition.set(false);
 }