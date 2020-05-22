public static void main(String[] args) throws Exception {

    final BufferedImage image = new BufferedImage(1280, 768,
            BufferedImage.TYPE_INT_RGB);
    JPanel canvas = new JPanel() {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(image, 0, 0, this);
        }
    };

    JFrame frame = new JFrame();
    frame.setLayout(new BorderLayout());   // <== make panel fill frame
    frame.add(canvas, BorderLayout.CENTER);
    frame.setSize(500, 500);
    frame.setVisible(true);

    // do you drawing somewhere else, maybe a different thread
    Graphics g = image.getGraphics();
    g.setColor(Color.red);
    for (int x = 0; x < 100; x += 5) {
        for (int y = 0; y < 100; y += 5) {
            g.drawRect(x, y, 1, 1);
        }
    }
    g.dispose();
    canvas.repaint();
}