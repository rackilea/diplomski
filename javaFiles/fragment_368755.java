public class DrawCirc extends JPanel {

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(150, 150);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.cyan);
        g.fillOval(100, 100, 50, 50);
    }
}