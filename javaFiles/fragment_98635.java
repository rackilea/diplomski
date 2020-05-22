public static class TestPanel extends JPanel {
    private Color color;

    public TestPanel(Color color) {
        this.color = color;
    }

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(color);
        g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
    }
}