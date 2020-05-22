executorService.shutdown();
try 
{
    executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
}
catch (InterruptedException e) 
{
    ...
}