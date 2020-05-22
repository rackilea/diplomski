public class Mutable<T> {

  private T value;

  public Mutable(final T value) {
    this.value = value;
  }

  public T get() {
    return this.value;
  }

  public void set(final T value) {
    this.value = value;
  }
}