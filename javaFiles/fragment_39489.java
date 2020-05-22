public class Test {

    final ProgressBar bar = new ProgressBar(0.0);
    TextArea area = new TextArea();
    int result;
    final Worker work = new Worker();
    final Worker2 work2 = new Worker2();

    final ExecutorService exec = Executors.newCachedThreadPool();

    // This already has values
    // it is not really a file array list in the map, but it is easier to show it this way
    Map<String, ArrayList<File>> mapTypes; 

// GUI Scene change happens here

    work.setOnSucceeded(e -> {
        work2.doSomething(work.getValue(), area);

        Task<Void> processAllFiles = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                final CountDownLatch latch2 = new CountDownLatch(Map.keySet().size());
                mapTypes.keySet().forEach((String s) -> {
                    exec.submit(() -> {
                        work3.doSomething(mapTypes.get(s), area);
                        latch2.CountDown();
                    });
                });
                latch2.await();
                return null ;
            }
        };

        processAllFiles.setOnSucceeded(evt -> {
            // executed on fx application thread:
            System.out.println("Done");
        });
    });

    bar.progressProperty().bind(work.progressProperty());
    exec.submit(work);
}