x.sum(1, 2, new Consumer<Integer>() {
    @Override
    public void accept(final Integer value) {
        System.out.println(value);
    }
});