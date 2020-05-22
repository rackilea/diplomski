public class ControlledBall extends JPanel {

    //...

    private Timer timer;

    public void stop() {
        if (timer == null) {
            return;
        }
        timer.stop();
        timer = null;
        x = 0;
        y = 0;
    }

    public void start() {
        if (timer != null) {
            return;
        }
        timer = new Timer(delay, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                move();
                repaint();
            }
        });
        timer.start();
    }