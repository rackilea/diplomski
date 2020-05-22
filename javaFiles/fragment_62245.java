public class RotateText {

    public static void main(String[] args) {
        new RotateText();
    }

    public RotateText() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Test");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private String textToDraw = "Stack Overflow";
        private double angle = 90;
        private Color drawColor = Color.BLACK;

        public TestPane() {
            Timer timer = new Timer(50, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    angle += 2;
                    repaint();
                }
            });
            timer.setRepeats(true);
            timer.setCoalesce(true);
            timer.start();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            final Graphics2D g2 = (Graphics2D) g.create();

            FontMetrics fm = g2.getFontMetrics();

            int textWidth = fm.stringWidth(textToDraw);
            int textHeight = fm.getHeight();

            BufferedImage img = new BufferedImage(textWidth, textHeight, BufferedImage.TYPE_INT_ARGB);
            Graphics2D ig = img.createGraphics();
            ig.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            ig.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            ig.setColor(drawColor);
            ig.drawString(textToDraw, 0, fm.getAscent());
            ig.dispose();

            int x = (getWidth() - textWidth) / 2;
            int y = (getHeight() - textHeight) / 2;

            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setTransform(AffineTransform.getRotateInstance(Math.toRadians(angle), getWidth() / 2, getHeight() / 2));
            g2.drawImage(img, x, y, this);
            g2.dispose();
        }

    }

}