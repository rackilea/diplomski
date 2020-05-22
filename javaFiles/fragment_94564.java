Boolean isPaused = false;
  private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {
    if (!isPaused ) {
      Game.gameMusic.pause();
      jButton6.setText("resume");
    }
    else {
      Game.gameMusic.resume();
      jButton6.setText("pause");
    }
    isPaused = !isPaused;
 }