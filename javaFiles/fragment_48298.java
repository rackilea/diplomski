List<Future<Long>> futures = new ArrayList<>();
for (int i = start; i < end;i = i * step) {
  int finalI = i;
  futures.add(exec.submit(() -> Sum(finalI, finalI * step)));
}

long sum = 0;  // No need to be volatile if you update in a single thread.
for (Future<Long> future : futures) {
  sum += future.get();
}