class TestA extends JButton {
    public TestA() {
        super.setContentAreaFilled(false);
    }

    public TestA(String text) {
        super(text);
        super.setContentAreaFilled(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Color pressedColor = Color.RED;
        if (getModel().isPressed()) {
            g.setColor(pressedColor);
        } else if (getModel().isRollover()) {
            g.setColor(pressedColor);
        } else {
            g.setColor(getBackground());
        }
        g.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }

    @Override
    public void setContentAreaFilled(boolean b) {
    }
}