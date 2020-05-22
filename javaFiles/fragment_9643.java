public class Cube<T> {
    private final List<List<List<T>>> elements = new ArrayList<List<List<T>>>();

    public T get(final int x, final int y, final int z) {
        if (elements.size() > x) {
            final List<List<T>> rowx = elements.get(x);
            if (rowx.size() > y) {
                final List<T> rowy = rowx.get(y);
                if (rowy.size() > z) {
                    return rowy.get(z);
                }
            }
        }
        return null;
    }
}