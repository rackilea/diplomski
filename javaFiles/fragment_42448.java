public class MyApplication {
    JFrame applicationFrame;

    Thread someThread;

    MyApplication() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override void run() {
                applicationFrame = new JFrame();

                // some more GUI initialization.
                applicationFrame.setVisible(true);
            }
        });

        someThread = new Thread(new Runnable() {
            @Override void run() {
                // do my work.
            }
        });

        someThread.start();
    }

    public static void main(String... args) {

        new MyApplication();
    }
}