boolean shutdown = false;
while (!shutdown) {
    try {
        WorkItem w = inQueue.take();
        if (w == QUEUE_IS_DEAD)
          shutdown = true;
        else
          w.consume();
    } catch (InterruptedException e) { 
        // possibly submit QUEUE_IS_DEAD to the queue
    }
}