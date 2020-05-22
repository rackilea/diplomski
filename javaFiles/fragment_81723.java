for (int i = 0; i < runnables.size(); ++i) {
  for (Runnable fn : runnables.subList(0, i + 1)) {
    fn.run();
  }
  validate();
}