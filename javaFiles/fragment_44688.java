long start = System.nanoTime();
long runs = 20000000;
for (int i = 0; i < runs; i++)
    System.nanoTime();
long time = System.nanoTime() - start;
System.out.printf("System.nanoTime() took an average of %,d ns.%n", time / runs);