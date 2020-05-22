public void run(){

      synchronized(i){
    while(i.get() < MAXI){
      System.out.println(name+ ". i = "
        +i.getAndIncrement());
    }

    System.out.println(name+" i = "+i.get());
      }
  }