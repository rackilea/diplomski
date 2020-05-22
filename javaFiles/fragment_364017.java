public static void method(final int x) {
    Runnable r = new AnonymousRunnable(x);
    r.run();
}

private static class AnonymousRunnable implements Runnable {
    private final int x;

    AnonymousRunnable(int x) {
        this.x = x;
    }

    @Override public void run() {
        System.out.println(x);
    }
}