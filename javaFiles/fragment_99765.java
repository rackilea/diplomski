public void deposit(String clientId){
   String id = clientId;
   while(id.equals("someClientID")){
         synchronized(lockObject){
             // Do your stuff here in a sync'd way
          }
   }
   else
   {
     // Do your stuff here in a NON synch'd way 
   }

 }