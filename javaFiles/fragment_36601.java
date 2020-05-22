private final Object POISON_PILL = new Object();

@Override
public void run() {
    //worker loop keeps taking en element from the queue as long as the producer is still running or as 
    //long as the queue is not empty:
    while(isRunning) {
        System.out.println("Consumer "+Thread.currentThread().getName()+" START");
        try {
            Object queueElement = inputQueue.take();
            if(queueElement == POISON_PILL) {
                 inputQueue.add(POISON_PILL);//notify other threads to stop
                 return;
            }
            //process queueElement
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

//this is used to signal from the main thread that he producer has finished adding stuff to the queue
public void finish() {
    //you can also clear here if you wanted
    isRunning = false;
    inputQueue.add(POISON_PILL);
}