for (int i = 0; i < 100; ++i) {
  new Thread() {
    @Override public void run() {
      Tree tree = new Sentence("your sentence").parse();
    }
  }.start();
}