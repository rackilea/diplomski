@Override
public Object call() throws Exception {
   //This for sure takes days to complete, so should through Cancellation exception because    timeout on invokeall set to 1 minute
    long val = 0;
    for (long i = 0; i < Long.MAX_VALUE - 5000; i++) {
        if(Thread.interruped()){
            throw new RuntimeException("Did not complete in time: " + i);
        }
        val += i;
    }
    return "Sucessfull Task1 object...";
}