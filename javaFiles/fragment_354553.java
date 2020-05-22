public class Iterables {
  /**
   * Adapts an {@link Iterator} to an {@link Iterable} for use in enhanced for loops.
   *
   * If {@link Iterable#iterator()} is invoked more than once, an
   * {@link IllegalStateException} is thrown.
   */
  public static <T> java.lang.Iterable<T> in(final Iterator<T> iterator) {
    assert iterator != null;
    class SingleUseIterable implements java.lang.Iterable<T> {
      private boolean used = false;

      @Override
      public Iterator<T> iterator() {
        if (used) {
          throw new IllegalStateException("SingleUseIterable already invoked");
        }
        used = true;
        return iterator;
      }
    }
    return new SingleUseIterable();
  }
}