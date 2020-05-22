public final void testGuavaSplit() {
    long start = System.currentTimeMillis();
    Splitter split = Splitter.on(" ");
    for (int i=0;i<RUNS;i++){
        Iterator<String> it = split.split(line).iterator();
        int x = Integer.parseInt(it.next());
        int y = Integer.parseInt(it.next());
    }
    System.out.println("GuavaSplit: "+(System.currentTimeMillis() - start)+"ms");
}