public void run()  {
    for (int i = 0; i < 100000, i++)  {
        System.out.println( "Produced: " + i );
        sharedQueue.add( new Integer( i ) );
        if (waitFlag)       // volatile access is cheaper than synch.
            synchronized (sharedQueue)  { sharedQueue.notifyAll(); }
    }
}