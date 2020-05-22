public class TestByteImage {

    public static void main(String[] args) {
        new TestByteImage();
    }

    public static byte[] extractBytes2(String ImageName) throws IOException {
        File imgPath = new File(ImageName);
        BufferedImage bufferedImage = ImageIO.read(imgPath);

        ByteOutputStream bos = null;
        try {
            bos = new ByteOutputStream();
            ImageIO.write(bufferedImage, "png", bos);
        } finally {
            try {
                bos.close();
            } catch (Exception e) {
            }
        }

        return bos == null ? null : bos.getBytes();

    }

    public TestByteImage() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException ex) {
                } catch (InstantiationException ex) {
                } catch (IllegalAccessException ex) {
                } catch (UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Test");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new ImagePane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class ImagePane extends JPanel {

        private BufferedImage original;
        private byte[] byteData;
        private BufferedImage fromBytes;

        public ImagePane() {
            String name = "/path/to/your/image";
            try {
                original = ImageIO.read(new File(name));
                byteData = extractBytes2(name);
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            setFont(UIManager.getFont("Label.font").deriveFont(Font.BOLD, 48f));

        }

        @Override
        public Dimension getPreferredSize() {
            return original == null ? super.getPreferredSize() : new Dimension(original.getWidth() * 2, original.getHeight());
        }

        protected void drawText(Graphics2D g2d, String text, int x, int width) {
            BufferedImage img = new BufferedImage(width, getHeight(), BufferedImage.TYPE_INT_ARGB);
            Graphics2D tmpg = img.createGraphics();
            tmpg.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            tmpg.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            tmpg.setFont(g2d.getFont());
            tmpg.setColor(Color.RED);
            FontMetrics fm = tmpg.getFontMetrics();
            int xPos = ((width - fm.stringWidth(text)) / 2);
            int yPos = ((getHeight() - fm.getHeight()) / 2) + fm.getAscent();
            tmpg.drawString(text, xPos, yPos);
            tmpg.dispose();

            AffineTransform transform = g2d.getTransform();
            g2d.setTransform(AffineTransform.getRotateInstance(Math.toRadians(-10), x + (x + width) / 2, getHeight() / 2));
            g2d.drawImage(img, x, 0, this);
            g2d.setTransform(transform);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (original != null) {
                g.drawImage(original, 0, 0, this);
                drawText((Graphics2D) g, "Original", 0, original.getWidth());
            }
            if (byteData != null && fromBytes == null) {
                try {
                    fromBytes = ImageIO.read(new ByteInputStream(byteData, byteData.length));
                } catch (IOException exp) {
                    exp.printStackTrace();
                }
            }
            if (fromBytes != null) {
                g.drawImage(fromBytes, getWidth() - fromBytes.getWidth(), 0, this);
                drawText((Graphics2D) g, "From Bytes", getWidth() - fromBytes.getWidth(), fromBytes.getWidth());
            }
        }
    }
}