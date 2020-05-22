synchronized (someObject) {
    if (!finished) {
        finished = true;
        task.interrupt();
        System.out.println("Test Terminated !!");
    }
}