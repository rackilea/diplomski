public static void floodFill(final BufferedImage image, int x, int y, final int fillColor) {
    final java.util.ArrayList<Point> examList = new java.util.ArrayList<Point>();

    final int initialColor = image.getRGB(x, y);
    examList.add(new Point(x, y));

    Timer timer = new Timer(40, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!examList.isEmpty()) {
                Point p = examList.remove(0);  // get and remove the first point in the list
                if (image.getRGB(p.x, p.y) == initialColor) {
                    int x = p.x;
                    int y = p.y;
                    image.setRGB(x, y, fillColor);  // fill current pixel

                    examList.add(new Point(x - 1, y));
                    examList.add(new Point(x + 1, y));
                    examList.add(new Point(x, y - 1));
                    examList.add(new Point(x, y + 1));

                }
                repaint(); // Assuming your painting the results to the screen
            } else {
                ((Timer)e.getSource()).stop();
            }
        }
    });
    timer.start();
}