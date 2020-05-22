public class TestPaintSpinner {

    public static void main(String[] args) {
        new TestPaintSpinner();
    }

    public TestPaintSpinner() {
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
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        public TestPane() {
            setDoubleBuffered(true);
            setLayout(new GridBagLayout());
            add(new JSpinner(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1)));

            JPanel panel = new JPanel();
            panel.add(new JLabel("Subpanel"));
            add(panel);
        }

//        public void paint(Graphics g) {
//            super.paint(g);
//
//            Graphics2D g2d = (Graphics2D) g;
//            Point2D sPoint = new Point2D.Float(0, 0);
//            Point2D ePoint = new Point2D.Float(this.getWidth(), this.getHeight());
//
//            g2d.setRenderingHint(
//                    RenderingHints.KEY_TEXT_ANTIALIASING,
//                    RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
//            super.paintComponents(g);
//            super.validate();
//            Toolkit.getDefaultToolkit().sync();
//            g.dispose();
//        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.

            Graphics2D g2d = (Graphics2D) g;
            Point2D sPoint = new Point2D.Float(0, 0);
            Point2D ePoint = new Point2D.Float(this.getWidth(), this.getHeight());

            // Note, this will effect every component painted after this one!!
            g2d.setRenderingHint(
                    RenderingHints.KEY_TEXT_ANTIALIASING,
                    RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        }
    }
}