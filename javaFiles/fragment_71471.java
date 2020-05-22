public class Yoyo {
  private final int from;
  private final int to;

  private int current;
  private int step;

  public Yoyo(int from, int to, int step) {
    if (step > to - from || to <= from) throw new IllegalArgumentException("invalid arguments");
    this.from = from;
    this.to = to;
    this.current = from - step;
    this.step = step;
  }

  public synchronized int next() {
    if (current + step > to || current + step < from) step = -step;
    return current += step;
  }

  public static void main(String[] args) {
    Yoyo y = new Yoyo(1, 10, 1);
    for (int i = 0; i < 25; i++) System.out.println(y.next());
  }
}