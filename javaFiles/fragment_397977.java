public static void main(String[] args) {

    JFrame frame = new JFrame("Test");

    frame.add(new JComponent() {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2d = (Graphics2D) g;

            // save the "old" transform
            AffineTransform old = g2d.getTransform();

            // update graphics object with the inverted y-transform
            g2d.translate(0, getHeight() - 1);
            g2d.scale(1, -1);

            // draw what you want
            g2d.drawLine(0, 0, 300, 200);

            // restore the old transform
            g2d.setTransform(old);
        }
    });

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 300);
    frame.setVisible(true);
}