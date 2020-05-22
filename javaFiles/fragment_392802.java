System.setOut(new PrintStream(System.out) {
  public void println(String s) {
    logger.log(s);
    super.println(s);
  }
  // override some other methods?
});