@Async
private synchronized void task(ConnectionObj connectionObj)
{
    Executors.newScheduledThreadPool(1).schedule(() -> {
        if(connectionObj.getState() == ONLINE) 
        {
            // don't do anything
        } 

        else 
        {
           doWork();
        }
    }, 2, TimeUnit.MINUTES);
}