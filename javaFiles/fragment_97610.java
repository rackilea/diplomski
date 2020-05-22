Iterable<Integer> it = new Generator<Integer>() {
    @Override protected void run() {
        for (int i = 0; i < 10; i++) {
            yield(i);
            if (i == 5) return;
        }
    }
};