import javax.swing.*;

class ShutDownHookDemo {

    public static void endMessage() {
        // clean up threads here..
        System.out.println("Thanks for using the app.");
    }

    public static void main(String[] args) {
        Thread t = new Thread() {
            public void run() {
                endMessage();
            }
        };
        Runtime.getRuntime().addShutdownHook(t);

        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(300,300);

        f.setVisible(true);
    }
}