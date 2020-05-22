public enum IntToLong implements Function<Integer, Long> {

    INSTANCE;

    @Override
    public Long apply(Integer input) {
        return input.longValue();
    }
}