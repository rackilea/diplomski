private volatile MySingleton  instance;

public static MySingleton getInstance() {
  //check if the instance doesn't exist yet, this is not threadsafe
  if(instance == null) {
    //the instance doesn't exist yet so synchronize and check again, since another thread 
    // might have entered this block in the meantime and instance is not null anymore
    synchronized(MySingleton.class) {
      if(instance == null) {
        instance = new MySingleton();
      }
    }
  }
  return instance;    
}