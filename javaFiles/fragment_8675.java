public class StdoutObserver implements Observer {
  @Override
  public void update(Observable o, Object arg) {
    System.out.println("Observable changed: " + o);
  }
}