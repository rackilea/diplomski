// create a pool with 10 threads
 ExecutorService threadPool = Executors.newFixedThreadPool(10);
 for (String file : files) {
     threadPool.submit(new MyFileProcessor(file));
 }
 // shutdown the pool once you've submitted your last job
 threadPool.shutdown();
 ...
 public class MyFileProcessor implements Runnable {
     private String file;
     public MyFileProcessor(String file) {
        this.file = file;
     }
     public run() {
        // process the file
     }
 }