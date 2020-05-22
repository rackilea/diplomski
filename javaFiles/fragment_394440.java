public class TestPane extends JPanel {

    public TestPane() {
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(200, 200);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Color c1 = new Color(0, 0, 255);
        Color c2 = new Color(0, 255, 255);
        GradientPaint gp = new GradientPaint(0, 0, c1, 0, 100, c2);

        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setPaint(gp);
        g2d.setTransform(AffineTransform.getTranslateInstance(100, 100));
        g2d.fill(new Rectangle(0, 0, 100, 100));
        g2d.dispose();

        g2d = (Graphics2D) g.create();
        g2d.setPaint(gp);
        g2d.fill(new Rectangle(0, 0, 100, 100));
        g2d.dispose();
    }

}