public void run()  {
    waitFlag = false;
    for (;;)  {
        Integer  ic = sharedQueue.poll();
        if (ic == null)  {
            synchronized (sharedQueue)  {
                waitFlag = true;
                // An add might have come through before waitFlag was set.
                ic = sharedQueue.poll();
                if (ic == null)  {
                    try  { sharedQueue.wait(); }
                    catch (InterruptedException ex)  {}
                    waitFlag = false;
                    continue;
                }
                waitFlag = true;
            }
        }
        System.out.println( "Consumed: " + ic );
    }
}