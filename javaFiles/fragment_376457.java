public void update() {
    if (pause) {
        gameState = pauseState;
    } else {
        gameState = playState;
    }

    gameState.update();
}

@Override
public void paint(Graphics g) {
    super.paint(g);
    Graphics2D g2d = (Graphics2D) g;
    gameState.paint(g2d)
}