public class Foo<E> {
  public static <E> Foo<E> withComparator(E e, Comparator<? super E> comparator){
    ...
  }
  public static <E extends Comparable> Foo<E> withoutComparator(E e) {
    ...
  }
}