public final static String TERMINATOR = new String("Terminator");  // actual text doesn't matter ... 
   // then, some loop taking from the Queue 
   while (keepGoing) {    
      String s = myQueue.take();    
      if (s == TERMINATOR) 
         keepGoing = false;    
     else   
       // normal processing of s 
   }