public class Counter {

  ... existing members ...

  public static void main(String[] args) {
    int initialValue = Integer.parseInt(args[0]);
    Counter tally = new Counter(initialValue);
    tally.count();
  }
}