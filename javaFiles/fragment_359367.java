...
AtomicBoolean isPaused = new AtomicBoolean(false);
...

private void gamePause() {
   synchronized(game) {
      game.isPaused.set(true);
      game.notify();
   }
}

private void gameContinue() {
   synchronized(game) {
      game.isPaused.set(false);
      game.notify();
   }
}
...