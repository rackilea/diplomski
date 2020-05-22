class CircleView extends JPanel {

    private static final long serialVersionUID = 1L;

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(100, 100);
    }

    @Override
    public void paintComponent(Graphics g) {
        int margin = 10;
        Dimension dim = getSize();
        super.paintComponent(g);
        g.setColor(Color.red);
        g.drawOval(margin, margin, dim.width - margin * 2, dim.height - margin * 2);
    }
}