public class ControlTimer {
    boolean stopped = false;
    boolean paused = false;
    TaskTimer timer;


    public ControlTimer() {
        timer = new TaskTimer();
        timer.start.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                timer.resume();
                timer.start();
            }
        });

        timer.stop.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                timer.stopped = true;
                timer.end();
            }
        });

        timer.pause.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                timer.end();
            }
        });
    }
}