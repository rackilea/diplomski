public class Test {
  private final Random random = new Random();
  private final int range;
  private int previous;

  Test(int range) { this.range = range; }

  int nextRnd() {
    if (previous == 0) return previous = random.nextInt(range) + 1;
    final int rnd = random.nextInt(range-1) + 1;
    return previous = (rnd < previous? rnd : rnd + 1);
  }


  public static void main(String[] args) {
    final Test t = new Test(4);
    for (int i = 0; i < 100; i++) System.out.println(t.nextRnd());
  }
}