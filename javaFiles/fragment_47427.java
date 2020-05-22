public class Test {

    private JFrame frame;
    JTextArea textArea;
    Thread t, t1;
    MyRunnable runner, runner1;

    public static void main(String[] args) {
        Test test = new Test();
    }

    public Test() {
        frame = new JFrame("Test");
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent event) {
                frame.setVisible(false);
                runner.stop(); runner1.stop();
                t.interrupt();t1.interrupt();
                frame.removeWindowListener(this);
                frame.dispose();
                frame = null;
            }
        });
        Container pane = frame.getContentPane();
        pane.setLayout(new FlowLayout());
        textArea = new JTextArea();
        textArea.setName("textArea1");
        pane.add(textArea);
        frame.setSize(400, 300);
        frame.setVisible(true);

        startTask();
    }

    void startTask() {
        runner = new MyRunnable("Label Text 1", 2000L);
        t = new Thread(runner);
        t.start();
        runner1 = new MyRunnable("Label Text 2", 3000L);
        t1 = new Thread(runner1);
        t1.start();
    }

    class MyRunnable implements Runnable {

        private String name;
        private Long waitTime;
        private Boolean active;

        public MyRunnable(String tn, Long time) {
            name = tn;
            waitTime = time;
            active = Boolean.TRUE;
        }

        public void stop(){
            active = Boolean.FALSE;
        }

        public void run() {
            while (active) {
                try {
                    Thread.sleep(waitTime);
                } catch (InterruptedException ex) {
                }
                textArea.append(name + "\n");
                System.out.println(name);
            }
        }
    }

}