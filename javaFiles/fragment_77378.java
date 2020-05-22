public static void main(String[] args) {
    // create an instance of that class, which keeps track of how many threads found an ip
    final WaitTask waitTask = new WaitTask();
    // create an int to know how many we are expecting
    final int totalThreadsRunning = 2;

    IpReader ipReader = new IpReader("stackoverflow.com");
    ipReader.setListener(new SimpleIpListener());

    // pass our object to the thread
    ipReader.setWaitTask(waitTask);
    new Thread(ipReader).start();

    IpReader ipReader2 = new IpReader("stackexchange.com");
    ipReader2.setListener(new SimpleIpListener());

    // pass our object to the thread
    ipReader2.setWaitTask(waitTask);
    new Thread(ipReader2).start();

    // Now wait until the wait task object is safe to be accessed

    synchronized(waitTask){

        // once we know it's safe let's check if we read as many responses as required

        while(waitTask.getNumberRead() < totalThreadsRunning )
        {
            // instead of looping forever wait for a thread to notify that 
            // the wait task number read was changed

            waitTask.wait();
            // the wait blocks execution and waits until waitTask was             
            // changed, after that the while loop condition gets evaluated
            // once we read as many as required we exit the loop
        }
    }

    // when we reach here all threads have finished so do anything you want
}