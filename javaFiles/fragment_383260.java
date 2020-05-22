public class Aaarggh {
  public static void main(String[] args) throws Exception {
    Signal.handle(new Signal("INT"), new SignalHandler () {
      public void handle(Signal sig) {
        System.out.println(
          "Aaarggh, a user is trying to interrupt me!!");
        System.out.println(
          "(throw garlic at user, say `shoo, go away')");
      }
    });
    for(int i=0; i<100; i++) {
      Thread.sleep(1000);
      System.out.print('.');
    }
  }
}