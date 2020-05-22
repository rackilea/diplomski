int chunkSize = (tasks + threads - 1) / threads; // divide by threads rounded up.
for (int t = 0; t < threads; t++) {
    int start = t * chunksSize;
    int end = Math.min(start + chunkSize, tasks);
    executor.submit(() -> {
         // inside the thread
         for (int i = start; i < end; i++) {
             process(i);
    });
}