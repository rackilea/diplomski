Private semaphore flag = new semaphore(10);//create a semaphore which contain 10 permits

   public void work(){
       flag.acquire();                        //acquire one permit
       //do the work
       flag.release();                        //release the permit
   }
   if(++count%10 == 0) dotest();
}

public void dotest(){                              
  while(true){
      if(flag.tryAcquire(10)) break;         //try acquire all permits. If true, all
                                             //the work threads will be blocked;
    }
    //do the test code 
    flag.release(10);                        //when test finish, release all permits,
                                             //then all blocking threads can resume.  
  }
}