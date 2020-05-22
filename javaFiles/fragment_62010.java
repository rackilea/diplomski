interface Predicate<T> {
    boolean evaluate(T value);
}

public int sum(int[] numbers, Predicate<Integer> predicate) {
    int sum = 0;
    for (int number : numbers) {
        if (predicate.evaluate(number)) {
            sum += number;
        }
    }
    return sum;
}