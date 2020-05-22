interface X {}
class U implements X {}
class V implements X {}

public static void main(String[] args) {
    Set<U> integers = new HashSet<U>();
    Set<V> doubles = new HashSet<V>();
    Set<X> numbers = union(integers, doubles);
}
public static <E> Set<E> union(Set<? extends E> s1,   Set<? extends E> s2) {
    return null;

}