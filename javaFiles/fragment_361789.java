import java.awt.EventQueue;
import java.util.concurrent.ExecutionException;
import javax.swing.JLabel;
import javax.swing.JWindow;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class QuickWorker {

    public static void main(String[] args) {
        new QuickWorker();
    }

    public QuickWorker() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JWindow window = new JWindow();
                window.add(new JLabel("Look no hands!"));
                window.pack();
                window.setLocationRelativeTo(null);

            }
        });
    }

    public class Worker extends SwingWorker<Object, Object> {

        private JWindow window;

        public Worker(JWindow window) {
            this.window = window;
        }

        @Override
        protected Object doInBackground() throws Exception {
            // Long running process...
            Thread.sleep(5000);
            return "All done";
        }

        @Override
        protected void done() {
            try {
                // Get the results of the process if you want them...
                get();
            } catch (InterruptedException | ExecutionException ex) {
                ex.printStackTrace();
            }
            window.dispose();
            // This is only here because the example will keep running without it :P
            System.exit(0);
        }
    }
}