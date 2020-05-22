Optional<Long> optionalLong = optionalInt.transform(new Function<Integer, Long>() {
    @Override
    public Long apply(Integer inputInt) {
        return inputInt.longValue();
    }
});