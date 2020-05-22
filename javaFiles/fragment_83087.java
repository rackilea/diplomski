public abstract class RecursiveGo extends JFrame implements ActionListener {

  private final UsefulSubset usefulSubset;

  public RecursiveGo() {
    usefulSubset = new UsefulSubset();
  }

  // Static, so you can address it as RecursiveGo.UsefulSubset.
  // Maybe it extends JFrame, too, and if made a top-level class
  // then RecursiveGo could further subclass the subset.
  public static class UsefulSubset {
    void methodCall {}
  }
}

class YourDriver {
  public static void main(String[] args) {
    RecursiveGo.UsefulSubset instance = new RecursiveGo.UsefulSubset();
    instance.methodCall();
  }
}