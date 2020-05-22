long start = System.nanoTime();
long runs = 20000000;
for (int i = 0; i < runs; i++)
    Thread.yield();
long time = System.nanoTime() - start;
System.out.printf("Thread.yield() took an average of %,d ns.%n", time / runs);