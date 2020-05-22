import javax.swing.JFrame;

public class TestBackgroudMethod {

    public static void main(final String[] args) {

        MyBackgroudMethod thread = new MyBackgroudMethod();
        thread.setDaemon(true);
        thread.start();

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame jFrame = new JFrame();
                jFrame.setSize(200, 200);
                jFrame.setVisible(true);
            }
        });
    }

    public static class MyBackgroudMethod extends Thread {

        @Override
        public void run() {
            while (true) {
                System.out.println("Executed!");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}