List<Future<?>> futures = new ArrayList<Future<?>>();
futures.add(executorService.submit(A));
futures.add(executorService.submit(B));
futures.add(executorService.submit(C));
futures.add(executorService.submit(D));
futures.add(executorService.submit(E));

//This loop must process the tasks in the order they were submitted: A, B, C, D, E
for (Future<?> future:futures) {
    ? result = future.get();
    // Some processing here
}