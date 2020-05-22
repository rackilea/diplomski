Runnable code = new Runnable() {
  @Override
  public void run() {
    for (String turn : controller.getTurns()) {
      playTurn(turn);
    }
  }
};

if (!SwingUtilities.isEventDispatchThread()) {
  code.run();
} else {
  new Thread(code).start();
}