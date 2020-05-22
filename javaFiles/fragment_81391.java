class Delegator {  
    private final AtomicInteger counter = new AtomicInteger(0);


  public int getNextCounter(){
      return counter.incrementAndGet();
   }
 }