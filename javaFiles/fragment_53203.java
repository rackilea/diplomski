class myclass extends JPanel {

    private boolean paintRect;

    public void setPaintRect(boolean paint) {
        paintRect = paint;
        repaint();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(120, 150);
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        if (paintRect) {
            g.setColor(Color.orange);
            g.fillRect(20, 50, 100, 100);
        }

    }
}