public class AppendImage {

    public static void main(String[] args) {
        new AppendImage();
    }

    public AppendImage() {
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

                JFrame frame = new JFrame();
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

        private BufferedImage sourceImage;
        private BufferedImage labeledImage;

        public ImagePane() {

            try {
                sourceImage = ImageIO.read(getClass().getResource("/source.jpg"));
                labeledImage = addLabel("Hello", sourceImage);
            } catch (IOException exp) {
                exp.printStackTrace();
            }

        }

        @Override
        public Dimension getPreferredSize() {
            int width = sourceImage.getWidth() + labeledImage.getWidth();
            int height = labeledImage.getHeight();

            return new Dimension(width, height);
        }

        protected BufferedImage addLabel(String label, BufferedImage sourceImage) {

            Font font = UIManager.getFont("Label.font");
            FontMetrics fm = getFontMetrics(font);
            int width = sourceImage.getWidth() + 2;
            int height = sourceImage.getHeight() + 4 + fm.getHeight() + 4;

            BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            Graphics2D g2d = image.createGraphics();
            g2d.setColor(Color.WHITE);
            g2d.fillRect(0, 0, width, height);
            g2d.setColor(Color.BLACK);
            g2d.setStroke(new BasicStroke(2, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
            g2d.drawRect(0, 0, width - 1, height - 1);
            g2d.drawImage(sourceImage, 1, 1, this);
            g2d.setColor(Color.RED);
            g2d.setStroke(new BasicStroke(2f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 10f, new float[]{10f}, 0f));
            g2d.drawLine(0, sourceImage.getHeight() + 2, image.getWidth(), sourceImage.getHeight() + 2);

            int y = sourceImage.getHeight() + (((image.getHeight() - sourceImage.getHeight()) - fm.getHeight()) / 2) + 2;
            g2d.drawString(label, 2, y + fm.getAscent());

            String logo = "Logo here";
            int x = image.getWidth() - fm.stringWidth(logo) - 12;
            g2d.drawString(logo, x, y + fm.getAscent());

            g2d.dispose();

            return image;

        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            int x = 0;
            g.drawImage(sourceImage, x, 0, this);
            x += sourceImage.getWidth();
            g.drawImage(labeledImage, x, 0, this);
        }
    }
}