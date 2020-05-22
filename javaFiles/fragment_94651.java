Map<Integer, Integer> map = new ConcurrentHashMap<>();
long start = System.nanoTime();
int runs = 200*1000*1000;
for (int r = 0; r < runs; r++) {
    map.put(r & 127, r & 127);
    map.get((~r) & 127);
}
long time = System.nanoTime() - start;
System.out.printf("Throughput of %.1f million accesses per second%n",
        2 * runs / 1e6 / (time / 1e9));