public static void increment() 
    {
        try
        {
            semaphore.acquire();
        }
        catch (InterruptedException e)
        {
            //process excp
        }
        sum = sum + one;
        one++;
        semaphore.release();
    }