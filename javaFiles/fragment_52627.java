public static void main(String[] args) {
    final List<Thread> threads = new ArrayList<>();
    for (int i = 0; i < 5; i++) {
        final new Incrementer i = new Incrementer();
        threads.add(i);
        i.start();
        final new Decrementer d = new Decrementer();
        threads.add(d);
        d.start();
    }
    for (final Thread t : threads) { t.join(); }
    System.out.println(counter);
}