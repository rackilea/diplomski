class DrawPanel extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawRect(10, 10, 200, 200);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(400, 300);
    }
}