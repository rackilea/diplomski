while (!Thread.currentThread().isInterrupted()) {
    String string;
    try {
         string = queue.take();
    } catch (InterruptedException e) {
         break;
    }
    // here is where you could check for a poison pill
    // something like: if (string == STOP_PILL) break;
    System.out.println("taken " + string + "from the queue");
}