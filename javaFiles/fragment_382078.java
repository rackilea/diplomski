public class FlexInterval<T extends Temporal> {

  ...

  @SuppressWarnings("unchecked") // code smell!
  public boolean contains(T test) {
    Comparable<T> t1 = (Comparable<T>) this.from;
    Comparable<T> t2 = (Comparable<T>) this.to;
    return (t1.compareTo(test) <= 0) && (t2.compareTo(test) >= 0);
  }
}