public static void main(String[] args) throws InterruptedException {

    for (int i = 0; i < 10; i++) {
        final long startTime = System.currentTimeMillis();
        Counter c = new Counter();
        Person p1 = new Person(c);
        Person p2 = new Person(c);
        p1.start();
        p2.start();
        p1.join();
        p2.join();
        final long endTime = System.currentTimeMillis();
        System.out.println(String.format("run %s: %s (%s ms)", i, c.getCount(), endTime - startTime));        
   }
}