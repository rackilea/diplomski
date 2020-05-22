public BiPredicate<Integer, Integer> function(int value) {
    if(value < 0) {
        return (a, b) -> a >= b;
    }
    return (a, b) -> a <= b;
}