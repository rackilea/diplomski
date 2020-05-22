public static void main(String[] args) {
    final JFrame frame = new JFrame();

    frame.getContentPane().add(new Circle());
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setSize(200, 200);
    frame.setVisible(true);
}

static class Circle extends JPanel {

    private int angle = 0;
    // The clip arc is going to be slightly larger than the actual
    // arc, otherwise some antialiasing pixels will be clipped off.
    private Arc2D clip = new Arc2D.Double(35,35,110,110,0,360,Arc2D.PIE);

    Circle() {

        ActionListener actionListener = new ActionListener() {

            int waitCounter = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                // When the angle reaches 360, set a wait for 100
                // runs of the timer.
                if (angle >= 360) {
                    angle = 0;
                    waitCounter = 100;
                }
                // If waiting, count down the time. When the wait
                // counter is zero, do the actual work.
                if (waitCounter > 0) {
                    waitCounter--;
                } else {
                    angle++;
                    repaint();
                }
            }
        };

        // The timer itself runs every 10 milliseconds.
        Timer timer = new Timer(10, actionListener);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D gg = (Graphics2D) g;
        gg.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);

        // Set the clipping arc to the current angle.
        clip.setAngleExtent(angle);
        gg.setClip(clip);

        // Draw a full circle. It will be clipped to the arc set above.
        gg.setColor(Color.BLACK);
        gg.drawOval(40,40,100,100);
    }
}