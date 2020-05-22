public class LessThan implements Predicate<Integer> {
  private final int point;

  public LessThan(final int point) {
      this.point = point;
  }

  public boolean test(final Integer incoming) {
    return incoming < point;
  }
}