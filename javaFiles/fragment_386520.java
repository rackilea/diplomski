ExecutorService service = Executors.newFixedThreadPool(5);
long startTs = System.nanoTime();

List<Future> futures = new ArrayList<>();
for (Runnable r : runnables) {
    futures.add(service.submit(r));
}
for (Future f : futures) { 
    f.get(); 
}

long durationNs = System.nanoTime() - startTs;