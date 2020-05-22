public class TestPane extends JPanel {

    private Polygon triangle;

    public TestPane() {
        triangle = new Polygon(new int[]{20, 40, 30}, new int[]{40, 40, 60}, 3);
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();

        g2d.setColor(Color.DARK_GRAY);
        g2d.fillRect(0, 0, 450, 40);
        g2d.fillRect(0, 260, 450, 40);

        g2d.setColor(Color.CYAN);
        AffineTransform at = AffineTransform.getTranslateInstance(0, 0);
        for (int index = 0; index < 4; index++) {

            Shape shape = at.createTransformedShape(triangle);
            g2d.fill(shape);
            at.translate(95, 0);

        }
    }
}