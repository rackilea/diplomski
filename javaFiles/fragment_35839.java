AtomicBoolean atomicBoolean;
AtomicInteger atomicInteger;
void processMessage(String message) {
    Runnable runner = new ... {
        boolean success = false;
        boolean boolState;
        int intState;
        while(!success) {
            boolState = atomicBoolean.get();
            success = atomicBoolean.compareAndSet(boolState, !boolState);
        }
        success = false
        while(!success) {
            intState = atomicInteger.get();
            success = atomicInteger.compareAndSet(intState, (intState + 1) % maxIntState);
        }
        if(boolState) {
          if(intState == 1) {
             //do something here
          }
          else if(intState == 2) {
             //do something here
          }
        }
    }
    poolA.executor(runner);
}