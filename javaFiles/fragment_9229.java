public class BouncingBall extends JApplet {

    private static final long serialVersionUID = 1L;

    public void init() {
        setSize(500, 500);
        setLayout(new BorderLayout());
        add(new BouncyPane());
    }

    protected class BouncyPane extends JPanel {

        private boolean b = true;
        private int speed = 50;
        private int pos = 250;
        private Timer timer;
        private int amount = 10;

        public BouncyPane() {
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {

                    if (speed > 250) {
                        amount = -10;
                    } else if (speed <= 0) {
                        amount = 10;
                    }

                    speed += amount;
                    timer.stop();
                    timer.setDelay(speed);
                    timer.restart();

                    repaint();
                }
            });

            timer = new Timer(speed, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (pos >= 400) {
                        b = false;
                    }
                    if (pos <= 100) {
                        b = true;
                    }
                    if (b == true) {
                        pos = pos + 5;
                    } else {
                        pos = pos - 5;
                    }

                    repaint();

                }
            });

            timer.setRepeats(true);
            timer.setCoalesce(true);
            timer.start();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
            g.setColor(Color.RED);
            g.drawOval(250, pos, 100, 100);
        }
    }
}