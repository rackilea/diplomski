public class NaturalComparator<T> {

    public int compare(T o1, T o2) {
        return o1.intValue() - o2.intValue();
    }
}