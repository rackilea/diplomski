public class NewClass extends JPanel {

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(400, 400);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.fillRect(0, 0, 100, 100);

        g.setColor(Color.GREEN);
        g.drawRect(50, 50, 100, 100);

        g.setColor(Color.RED);
        g.drawString("Hello", 200, 200);

        g.setColor(Color.RED);
        g.fillOval(240, 40, 100, 30);

    }
}