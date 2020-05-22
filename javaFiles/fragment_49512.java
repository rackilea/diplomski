import javax.swing.JFrame;
import javax.swing.SwingWorker;

public class TestBackgroudMethod {

    public static void main(final String[] args) {

        new SwingBackgroupWorker().execute();

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame jFrame = new JFrame();
                jFrame.setSize(200, 200);
                jFrame.setVisible(true);
            }
        });
    }

    public static class SwingBackgroupWorker extends SwingWorker<Object, Object> {

        @Override
        protected Object doInBackground() throws Exception {
            while (true) {
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        System.out.println("executed");
                        // here the swing update
                    }
                });
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}