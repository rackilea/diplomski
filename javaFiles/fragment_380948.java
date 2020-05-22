synchronized (pendingActions) {
  for (Action r : pendingActions) {
    r.run();
  }
  r.clear();
}