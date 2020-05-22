class Worker {

    private final CountDownLatch startSignal;
    private final CountDownLatch doneSignal;
    private final int threadNumber;

    Worker(
        CountDownLatch startSignal,
        CountDownLatch doneSignal,
        int threadNumber
    ){

        this.startSignal = startSignal;
        this.doneSignal = doneSignal;
        this.threadNumber = threadNumber;

    }

    public String[][] getSomeStrArrArr() {

        try {

            startSignal.await();

            if (threadNumber == 1) {
                System.out.println("Running thread number 1");
            }

            if (threadNumber == 2) {
                System.out.println("Running thread number 2");
            }

            if (threadNumber == 3) {
                System.out.println("Running thread number 3");
            }

            doneSignal.countDown();

        } catch (InterruptedException ex) {

            System.out.println(
                    "Thread number "+threadNumber+" has been interrupted."
            );

        }

        // replace these 2 lines with the actual code to get the String[][]
        String[][] someStrArrArr = new String[1][1];
        someStrArrArr[0][0] = "Done with thread number "+threadNumber;

        return someStrArrArr;

    }

    public Callable<String[][]> getSomeCallableStrArrArr(){
        return new Callable<String[][]>() {
            public String[][] call() throws Exception {
                return getSomeStrArrArr();
            }
        };
    }

}