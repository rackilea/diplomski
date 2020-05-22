public class Generic<T> {
  private int count;
  public int Count()
  {
    return count;
  }
  public void set(Generic<? extends T> other)
  {
    int something = other.Count();
    int somethingElse = other.count;
  }
}