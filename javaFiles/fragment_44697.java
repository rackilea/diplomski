public static void main(String... args) throws Exception {
    long start = System.nanoTime();
    long time = start;
    while(time < start + 3e10) {
        long now = System.nanoTime();
        if (now < time || now > time + 50000) {
            System.out.println(now - time);
            now = System.nanoTime();
        }
        time = now;
    }
}