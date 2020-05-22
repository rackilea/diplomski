int[] numbers = { 2, 2, 5, 6, 6 };

int sum = sum(numbers, new Predicate<Integer>() {
    @Override
    public boolean evaluate(Integer value) {
        return !(value == 1 || value == 3 || value == 5);
    }
});