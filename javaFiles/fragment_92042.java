public class AATest {

    public static void main(String[] args) {
        new AATest();
    }

    public AATest() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new PaintPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class PaintPane extends JPanel {

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(215, 110);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            RenderingHints hints = new RenderingHints(
                    RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setRenderingHints(hints);
            g2d.setColor(Color.RED);
            drawShape(g2d, 5, 5);
            g2d.dispose();
            g2d = (Graphics2D) g.create();
            g2d.setColor(Color.BLUE);
            drawShape(g2d, 110, 5);
            g2d.dispose();
        }

        protected void drawShape(Graphics2D g2d, int x, int y) {
            g2d.draw(new Ellipse2D.Float(x, y, 100, 100));
        }
    }
}