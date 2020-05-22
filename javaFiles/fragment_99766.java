public void deposit(String clientId){
    String id = clientId;
   // callers is a ConcurrenthashMap<String,String>
     while(callers.get(id) != null){  
     synchronized(callers.get(id)){  // client already in call, so wait
        wait(); 
     }
   }       
      callers.put(id,id);  // client is ready to run a new call, so setup 
      // Do your stuff here in a NON synch'd way 
 synchronized(callers.get(id)){  // client done with a call , 
                      //so notify others who are calling
    callers.put(id,null);
    notifyAll();
       }
}