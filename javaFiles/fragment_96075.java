public class NoRepeatFilter<T> implements Predicate<T> {
    private T prevValue;
    @Override
    public boolean test(T value) {
        if (value.equals(this.prevValue))
            return false;
        this.prevValue = value;
        return true;
    }
}