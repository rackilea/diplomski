public class Test {
    public static void main(String[] args) throws InterruptedException, InvocationTargetException {
        JFrame frame = new JFrame("Image Test");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        BufferedImage image = new BufferedImage(100, 100, BufferedImage.TYPE_USHORT_GRAY);
        ImageComponent component = new ImageComponent(image);
        frame.add(component);
        frame.pack();
        frame.setVisible(true);

        short gray = 0;
        short[] data = ((DataBufferUShort) image.getRaster().getDataBuffer()).getData();
        while (true) {
            for (int i = 0; i < data.length; i++) {
                data[i] = gray;
            }
            Thread.sleep(20);
            gray += 1000;
            component.repaint();
        }
    }

    static class ImageComponent extends JComponent {
        private BufferedImage image;

        public ImageComponent(BufferedImage image) {
            this.image = image;
            this.setPreferredSize(new Dimension(image.getWidth(), image.getHeight()));
        }

        @Override
        protected void paintComponent(Graphics g) {
            g.drawImage(image, 0, 0, image.getWidth(), image.getHeight(), null);
        }
    }
}