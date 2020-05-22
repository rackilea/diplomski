AtomicInteger b = new AtomicInteger(10);
Consumer<Integer> lm2 = a -> {
    b.set(a); // compiler complains
    System.out.println(b);
};
lm2.accept(20);