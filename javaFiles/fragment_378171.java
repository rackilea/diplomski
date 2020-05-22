List<Record> records = ...;

ExecutorService executor = Executors.newFixedThreadPool(10);

for (Record r : records) {
   executor.submit(r);
}

// At the end stop the executor
executor.shutdown();