ReturnsANumber v = new ReturnsANumber() {
    ...
    @Override
    public int getIt() {
        ReturnsANumber w = Optional.of(this).map(outer ->
                new ReturnsANumber() {
                    int theNumber() {
                        return 1;
                    }
                    public int getIt() {
                        return outer.theNumber();
                    }
                }).get();
        return w.getIt();
    }
};