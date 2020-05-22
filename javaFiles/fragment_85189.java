MouseAdapter ma = new MouseAdapter() {

    @Override
    public void mouseMoved(MouseEvent e) {
        playGameHighlighted = playGame.contains(e.getPoint());
        quitGameHighlighted = quitGame.contains(e.getPoint());
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (playGameHighlighted) {
            scene = Scene.GAME;
            repaint();

            System.out.println("playGameHighlighted and mouse clicked");
        }

        if (quitGameHighlighted) {
            running = false;

            System.out.println("quitGameHighlighted and mouse clicked");
        }

        System.out.println("mouse clicked");
    }
};
addMouseMotionListener(ma);
addMouseListener(ma);