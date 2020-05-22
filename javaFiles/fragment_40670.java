public enum Listener implements Listenable {
  INSTANCE;

  public void listen() {
    System.out.println("I am listening");
  }
}