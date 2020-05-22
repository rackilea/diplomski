ExecutorService executor = Executors.newFixedThreadPool(10);
List<Future> futures = new ArrayList<> ();

for (Runnable r : yourListOfRunnables) {
    futures.add(executor.submit(r));
}

//now do the equivalent of join:

try {
    for (Future f : futures) {
        f.get(); //blocks until the runnable completes
    }
} catch (...) { }