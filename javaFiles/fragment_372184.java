public class TestClock {

    public static void main(String[] args) {
        new TestClock();
    }

    public TestClock() {
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
                frame.add(new ClockPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    protected class ClockPane extends JPanel {

        public ClockPane() {
            Timer timer = new Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    repaint();
                }
            });
            timer.setRepeats(true);
            timer.setCoalesce(false);
            timer.start();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        protected Point getPointTo(float angle) {

            int x = Math.round(getWidth() / 2);
            int y = Math.round(getHeight() / 2);

            double rads = Math.toRadians(angle);
            // This is an arbitrary amount, you will need to correct for this
            // I'm working of a width of 200 pixels, so that makes the radius
            // 100...
            int radius = 100;

            // Calculate the outter point of the line
            int xPosy = Math.round((float) (x + Math.cos(rads) * radius));
            int yPosy = Math.round((float) (y - Math.sin(rads) * radius));

            return new Point(xPosy, yPosy);

        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();

            g2d.setColor(Color.RED);

            Calendar cal = Calendar.getInstance();
            int seconds = cal.get(Calendar.SECOND);
            float angle = -(360f * (seconds / 60f));
            angle += 90; // Correct for 0 being out to the right instead of up

            Point p = getPointTo(angle);

            int x = getWidth() / 2;
            int y = getHeight() / 2;

            g2d.drawLine(x, y, p.x, p.y);

            FontMetrics fm = g2d.getFontMetrics();
            String text = Integer.toString(seconds);
            g2d.drawString(text, getWidth() - fm.stringWidth(text), getHeight() - fm.getHeight() + fm.getAscent());

            g2d.dispose();
        }
    }
}