@FunctionalInterface
public interface ThrowingFunction<T, R> {
  R apply(T t) throws MyException;

  default <U> ThrowingFunction<T, U> andThen(ThrowingFunction<R, U> follow) {
    Objects.requireNonNull(follow); // Fail fast
    return t -> follow.apply(this.apply(t));
  }
}