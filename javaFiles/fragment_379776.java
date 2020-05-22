import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class ProgressTest {

    public static void main(String[] args) {
        new ProgressTest();
    }

    public ProgressTest() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel implements ProgressMonitor{

        private Map<DownloadWorker, Double> workerProgress;
        private int taskCount;
        private double progress;

        public TestPane() {
            workerProgress = new HashMap<>(25);
            taskCount = 10;
            for (int index = 0; index < 10; index++) {
                DownloadWorker worker = new DownloadWorker(index, this);
                workerProgress.put(worker, 0d);
                worker.execute();
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            int width = (int)Math.round(getWidth() * progress);
            g2d.setColor(UIManager.getColor("ProgressBar.selectionBackground"));
            g2d.fillRect(0, 0, width, getHeight());
            g2d.dispose();
        }

        @Override
        public void progressWasUpdated(DownloadWorker worker, double progress) {
            workerProgress.put(worker, progress);
            double sum = 0;
            for (Map.Entry<DownloadWorker, Double> entry : workerProgress.entrySet()) {
                sum += entry.getValue();
            }
            this.progress = sum / (double)taskCount;
            repaint();
        }

    }

    public interface ProgressMonitor {
        public void progressWasUpdated(DownloadWorker worker, double progress);
    }

    private Random rnd = new Random();

    public class DownloadWorker extends SwingWorker<Void, Double> {

        private int index;
        private ProgressMonitor progressMonitor;

        public DownloadWorker(int index, ProgressMonitor progressMonitor) {
            this.progressMonitor = progressMonitor;
            this.index = index;
        }

        @Override
        protected Void doInBackground() throws Exception {
            double progress = 0;
            do {
                progress += Math.random() * 0.1;
                progress = Math.min(progress, 1.0);
                publish(progress);
                Thread.sleep(rnd.nextInt(490) + 10);
            } while (progress < 1.0);
            publish(1.0);
            System.out.println(index + " has ended");
            return null;
        }

        public int getIndex() {
            return index;
        }

        @Override
        protected void process(List<Double> chunks) {
            progressMonitor.progressWasUpdated(this, chunks.get(chunks.size() - 1));
        }

    }

}