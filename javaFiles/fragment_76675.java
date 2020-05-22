public class TestBlackAndWhite {

    public static void main(String[] args) {
        new TestBlackAndWhite();
    }

    public TestBlackAndWhite() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception ex) {
                }

                JFrame frame = new JFrame("Test");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

            }
        });
    }

    public class TestPane extends JPanel {

        private BufferedImage master;
        private BufferedImage grayScale;
        private BufferedImage blackWhite;

        public TestPane() {
            try {
                master = ImageIO.read(new File("C:/Users/shane/Dropbox/pictures/439px-Join!_It's_your_duty!.jpg"));
                grayScale = ImageIO.read(new File("C:/Users/shane/Dropbox/pictures/439px-Join!_It's_your_duty!.jpg"));
                ColorConvertOp op = new ColorConvertOp(ColorSpace.getInstance(ColorSpace.CS_GRAY), null);
                op.filter(grayScale, grayScale);

                blackWhite = new BufferedImage(master.getWidth(), master.getHeight(), BufferedImage.TYPE_BYTE_BINARY);
                Graphics2D g2d = blackWhite.createGraphics();
                g2d.drawImage(master, 0, 0, this);
                g2d.dispose();

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        @Override
        public Dimension getPreferredSize() {
            Dimension size = super.getPreferredSize();
            if (master != null) {
                size = new Dimension(master.getWidth() * 3, master.getHeight());
            }
            return size;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (master != null) {

                int x = (getWidth() - (master.getWidth() * 3)) / 2;
                int y = (getHeight() - master.getHeight()) / 2;

                g.drawImage(master, x, y, this);
                x += master.getWidth();
                g.drawImage(grayScale, x, y, this);
                x += master.getWidth();
                g.drawImage(blackWhite, x, y, this);

            }
        }


    }
}