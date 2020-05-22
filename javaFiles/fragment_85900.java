public class TestSword {

    public static void main(String[] args) {
        new TestSword();
    }

    public TestSword() {
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
                frame.add(new SwordPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class SwordPane extends JPanel {

        private BufferedImage character;
        private BufferedImage sword;
        private double angle = 0;

        public SwordPane() {
            try {
                character = ImageIO.read(new File("character.png"));
                sword = ImageIO.read(new File("Sword.png"));
            } catch (IOException exp) {
                exp.printStackTrace();
            }

            Timer timer = new Timer(100, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    angle += 10;
                    if (angle > 360) {
                        angle -= 360;
                    }
                    repaint();
                }
            });
            timer.setRepeats(true);
            timer.setCoalesce(true);
            timer.start();

        }

        @Override
        public Dimension getPreferredSize() {
            int width = character.getHeight() + sword.getWidth();
            int height = character.getHeight() + sword.getWidth();

            return new Dimension(width * 2, height * 2);
        }

        protected Point getSwordHandlePoint() {

            int radius = 272; // This is the height of the character...

            int x = Math.round(getWidth() / 2);
            int y = Math.round(getHeight() / 2);

            double rads = Math.toRadians(angle - 180); // Make 0 point out to the right...
            // If you add sword.getWidth, you might be able to change the above...
            int fullLength = Math.round((radius / 2f)) - sword.getWidth();

            // Calculate the outter point of the line
            int xPosy = Math.round((float) (x + Math.cos(rads) * fullLength));
            int yPosy = Math.round((float) (y - Math.sin(rads) * fullLength));

            return new Point(xPosy, yPosy);

        }

        @Override
        protected void paintComponent(Graphics g) {

            super.paintComponent(g);

            Graphics2D g2d = (Graphics2D) g.create();

            int x = (getWidth() - character.getWidth()) / 2;
            int y = (getHeight() - character.getHeight()) / 2;

            g2d.drawImage(character, x, y, this);

            x = getWidth() / 2;
            y = getHeight() / 2;

            Point p = getSwordHandlePoint();
            g2d.setColor(Color.RED);
            g2d.drawLine(x, y, p.x, p.y);

            AffineTransform at = AffineTransform.getTranslateInstance(p.x, p.y);
            at.rotate(Math.toRadians(-angle));
            g2d.setTransform(at);
            g2d.drawImage(sword, 0, 0, this);

            g2d.dispose();

        }
    }
}