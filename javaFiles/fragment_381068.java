public class F1<T extends Comparable<T>> implements Comparable<F1<T>> {
    T t;

    @Override public int compareTo(F1<T> other){
        return t.compareTo(other.t);
    }
}