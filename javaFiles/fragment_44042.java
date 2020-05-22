public class Test {
  final Runnable runner;

  public Test(final String text) {
    runner = new Runnable () {
      @Override
      public void run () {
        System.out.println("Run: "+text);
      }
    };
  }
}