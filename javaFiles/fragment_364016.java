public static void method(final int x) {
    Runnable r = new Runnable() {
        @Override public void run() {
            System.out.println(x);
        }
    };
    r.run();
}