class NumericCalculator<T> {
    public void calculate(T one, T two) {
        T result = one * two; // compiler error
    }
}

class LongCalculator extends NumericCalculator<Long> {
    public void calculate(Long one, Long two) {
        Long result = one * two; // yes
    }
}