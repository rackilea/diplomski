boolean added = false;

while ( !added){
    try{
        queue.put(value);
        added = true;
    }catch(InterruptedException ie){
        // do something if required

        // make sure to set the interrupted flag on the thread, since it was cleared
        // when the exception was thrown
        Thread.currentThread().interrupt();
    }
}

if(Thread.currentThread.isInterrupted()){
    // you were previously interrupted before, so try to exit gracefully
    return;
}