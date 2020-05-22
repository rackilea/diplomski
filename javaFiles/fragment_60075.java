import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

public class SwingWorkerExample {

    private JProgressBar pb;
    private JPanel content;

    public static void main(String[] args) {

        new SwingWorkerExample();

    }

    public SwingWorkerExample() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                pb = new JProgressBar();
                content = new JPanel();
                content.setBorder(new EmptyBorder(10, 10, 10, 10));

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setContentPane(content);
                frame.setLayout(new GridBagLayout());
                frame.add(pb);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                LoadMaster master = new LoadMaster();
                master.addPropertyChangeListener(new LoadMasterPropertyChanegHandler(SwingWorkerExample.this));
                master.execute();
            }
        });
    }

    protected void showProgress(int value) {
        pb.setValue(value);
    }

    protected void loadCompleted() {
        content.removeAll();
        content.setLayout(new GridLayout(0, 1));
        content.add(new JLabel("All your base are belong to us"));
        content.revalidate();

        LoadStuffWorker stuffWorker = new LoadStuffWorker(this);
        stuffWorker.execute();
    }

    protected void loadFailed() {
        content.removeAll();
        content.setLayout(new GridLayout(0, 1));
        content.add(new JLabel("Fail"));
        content.revalidate();
    }

    protected void setVersion(String value) {
        content.add(new JLabel("Version: " + value));
        content.revalidate();
    }

    protected void failed(String fail) {
        content.add(new JLabel(fail));
        content.revalidate();
    }

    public class LoadMaster extends SwingWorker<Void, Progress> {

        @Override
        protected Void doInBackground() throws Exception {
            System.out.println("Working hard here, nothing to see...");
            for (int index = 0; index < 100; index++) {
                Thread.sleep(10);
                setProgress(index);
            }
            return null;
        }

        @Override
        protected void done() {
            try {
                get();
            } catch (Exception e) {
            }
        }

    }

    public class LoadStuffWorker extends SwingWorker<String, Void> {

        private SwingWorkerExample example;

        public LoadStuffWorker(SwingWorkerExample example) {
            this.example = example;
        }

        @Override
        protected String doInBackground() throws Exception {
            System.out.println("Hanging about in the background");
            Thread.sleep(3000);
            return "Hello from the dark side";
        }

        @Override
        protected void done() {
            try {
                String value = get();
                example.setVersion(value);
            } catch (InterruptedException | ExecutionException ex) {
                example.failed("Fail while doing version check");
            }
        }

    }

    public class Progress {
    }

    public class LoadMasterPropertyChanegHandler implements PropertyChangeListener {

        private SwingWorkerExample example;

        public LoadMasterPropertyChanegHandler(SwingWorkerExample example) {
            this.example = example;
        }

        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            System.out.println(evt.getPropertyName());
            if ("progress".equalsIgnoreCase(evt.getPropertyName())) {
                int value = (int) evt.getNewValue();
                example.showProgress(value);
            } else if ("state".equalsIgnoreCase(evt.getPropertyName())) {
                SwingWorker worker = (SwingWorker) evt.getSource();
                if (worker.isDone()) {
                    try {
                        worker.get();
                        example.loadCompleted();
                    } catch (InterruptedException | ExecutionException exp) {
                        example.loadFailed();
                    }
                }
            }
        }

    }

}