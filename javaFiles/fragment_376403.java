public static void main(String args[]) throws Exception {

    JFrame frame = new JFrame("Test");
    frame.add(new JTable(new DefaultTableModel() {
        @Override
        public int getColumnCount() {
            return 10;
        }
        @Override
        public int getRowCount() {
            return 10;
        }
        @Override
        public Object getValueAt(int row, int column) {
            return row + " " + column;
        }
    }));

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 300);
    frame.setVisible(true);

    BufferedImage image = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);
    Graphics g = image.getGraphics();
    g.translate(-100, -100);

    frame.paintComponents(g);

    g.dispose();

    ImageIO.write(image, "png", new File("frame.png"));
}