public class Bar implements Comparable<Bar> {
  private int priority;

  @Override
  public int compareTo(Bar b) {
    return b.getPriority() - this.priority;
  }
}