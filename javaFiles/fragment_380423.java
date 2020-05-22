public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
    for (Point p : point) {
        if (p != null) {
            m.drawParticle(p.x, p.y);
        }
    }
    m.drawParticle(pressedX, pressedY);
}