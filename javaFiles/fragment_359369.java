public void checkLives() {
    if (bricksLeft == 0) {
        ...
        if(!game.isPaused().get())
           stop();
    }
    if (lives == 0) {
        repaint();
        if(!game.isPaused().get())
           stop();
    }
}