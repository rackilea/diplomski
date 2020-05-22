public GamePanel() {
    paintBackground(gameScreenGraphics);
    paintScore(gameScreenGraphics);
    paintBouncers(gameScreenGraphics);
    addMouseMotionListener(this);
    repaint();
}