public abstract class Superclass {
  protected final int compareBasePortionTo(Superclass other) { ... };
}

public class Subclass extends Superclass implements Comparable<Subclass> {
  public int compareTo(Subclass other) {
    int baseCmp = compareBasePortionTo(other);

    if (baseCmp != 0)
      return baseCmp;

    // compare subclass properties
  };
}