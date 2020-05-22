public static class ShapePane extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Custom Painting here...
    }

    public Dimension getPreferredSize() {
        return new Dimension(200, 200);
    }

}