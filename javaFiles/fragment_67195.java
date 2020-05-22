Function<Apple, Integer> getColor = new Function<Apple, Integer>() {
    @Override
    public Integer apply(Apple apple) {
        return apple.getColor();
    }
};