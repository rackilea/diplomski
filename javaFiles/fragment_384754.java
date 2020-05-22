futures = executor.invokeAll(callables, TIMEOUT_SECONDS, TimeUnit.SECONDS);

int index = 0; // Index used for for-loop

for (Future<Object> future : futures){
    try{
        PingStatus status = (PingStatus)future.get();
        // do stuff
    }catch(CancellationException e){
        Callable<Object> offendingCallable = callables.get(index);

        // deal with object here 
    }

    index++;
}