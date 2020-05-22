private static class ScheduledPrinter implements Runnable {

    private final Queue<Integer> numsPrinted;

    public ScheduledPrinter(Queue<Integer> numsPrinted) {
        this.numsPrinted = numsPrinted; // storing the reference
    }

    @Override
    public void run() {
        limit++;
        if(limit==5) {
            //scheduler.awaitTermination(timeout, unit)
            scheduler.shutdown();
            storeAndPrintNum(limit);
        } else {
            storeAndPrintNum(testNum);
        }
    }

    private void storeAndPrintNum(int num) {
        numsPrinted.add(num); // using the reference
        System.out.println(num);
    }
}