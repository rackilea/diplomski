executor.shutdown();
while (!executor.isTerminated()) {}

for (int i = 0; i < 1000; i++) {
  cache.invalidate(i);
}