private final ReentrantLock lock = new ReentrantLock();

if(toModify[j]==1)        
  {   
      lock.lock();  // block until condition holds
 try {
   getUpdate(methods_list[j],username, password);         
 } finally {
   lock.unlock()
 }

}