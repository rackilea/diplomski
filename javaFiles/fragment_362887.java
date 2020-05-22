@FunctionalInterface
public interface Property<T, P> {

  P extract(T object);

  default Predicate<T> like(T example) {
     Predicate<P> equality = Predicate.isEqual(extract(example));
     return (value) -> equality.test(extract(value));
  }
}