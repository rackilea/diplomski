public class TestHello {

    private static HelloTask task;

    public static void main(String[] args) {

        Thread thread = new Thread((task = new HelloTask()));
        thread.setDaemon(true);
        thread.start();

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());
        frame.setSize(200, 200);
        frame.setLocationRelativeTo(null);

        JButton goButton = new JButton("Go");
        JButton stopButton = new JButton("Stop");

        goButton.setActionCommand("Go");
        stopButton.setActionCommand("Stop");

        ActionHandler handler = new ActionHandler();

        goButton.addActionListener(handler);
        stopButton.addActionListener(handler);

        frame.add(goButton);
        frame.add(stopButton);

        frame.setVisible(true);

    }

    public static class ActionHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getActionCommand().equals("Go")) {
                task.start();
            } else if (e.getActionCommand().equals("Stop")) {
                task.pause();
            }

        }

    }

    public static class HelloTask implements Runnable {

        private static final Object WAIT_LOCK = new Object();
        private boolean dump = false;

        public void start() {
            synchronized (WAIT_LOCK) {
                dump = true;
                WAIT_LOCK.notify();
            }
        }

        public void pause() {
            synchronized (WAIT_LOCK) {
                dump = false;
                WAIT_LOCK.notify();
            }
        }

        @Override
        public void run() {
            while (true) {
                while (dump) {
                    System.out.println("Hello");
                }
                try {
                    synchronized (WAIT_LOCK) {
                        WAIT_LOCK.wait();
                    }
                } catch (Exception e) {
                }
            }
        }
    }
}