long start = 0;
for(int r = -warmup; r < runs; r++) {
    if (r == 0) start = System.nanoTime();
    // do test
}
long avg = (System.nanoTime() - start)/runs;