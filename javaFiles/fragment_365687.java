public void playTurn(String turn) {
  if (controller.givePlayers().contains(turn)) {
    while (!turnFinished) {
      if (!button1.isEnabled() && !button1.isEnabled() && !button1.isEnabled() && !button1.isEnabled()) {
        turnFinished = true;
      }
    }
  } else {
    deletePlayer(turn);
  }
}