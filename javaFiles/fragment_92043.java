public class ShapedWindow {

    public static void main(String[] args) {
        new ShapedWindow();
    }

    public ShapedWindow() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JWindow frame = new JWindow();
                frame.setBackground(new Color(0, 0, 0, 0));
                frame.setContentPane(new ShapedPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                frame.setAlwaysOnTop(true);
            }
        });
    }

    public class ShapedPane extends JPanel {

        public ShapedPane() {

            setOpaque(false);
            setLayout(new GridBagLayout());

            JButton button = new JButton("Close");
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });

            add(button);

        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
            Graphics2D g2d = (Graphics2D) g.create();
            RenderingHints hints = new RenderingHints(
                    RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setRenderingHints(hints);
            g2d.setColor(getBackground());
            g2d.fill(new Ellipse2D.Float(0, 0, getWidth(), getHeight()));
            g2d.dispose();
        }
    }

}