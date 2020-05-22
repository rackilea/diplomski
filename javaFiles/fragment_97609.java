Iterable<Integer> it = new Yielder<Integer>() {
    @Override protected void yieldNextCore() {
        for (int i = 0; i < 10; i++) {
            yieldReturn(i);
            if (i == 5) yieldBreak();
        }
    }
};