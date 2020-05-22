private Timer timer;
...

timer = new javax.swing.Timer(50, new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent arg0) {
        y = ++x;
        ball.repaint();

        if (x > 350) {
            timer.stop();
        }
    }
});
timer.setRepeats(true);
timer.start();

public static void main(String args[]) {
    SwingUtilities.invokeLater(new Runnable() {

        @Override
        public void run() {
            Animate ballRoll = new Animate();
            ballRoll.go();
        }
    });
}

class MyRoll extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ...
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(..., ...);
    }
}