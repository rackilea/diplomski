import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class SwingWorkerProgress {

    public static void main(String[] args) {
        new SwingWorkerProgress();
    }

    public SwingWorkerProgress() {
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

    public class TestPane extends JPanel {

        private JProgressBar pb;
        private JButton startButton;

        public TestPane() {

            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;

            pb = new JProgressBar();
            startButton = new JButton("Make it so");

            add(pb, gbc);
            add(startButton, gbc);

            startButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    startButton.setEnabled(false);
                    ProgressWorker worker = new ProgressWorker();
                    worker.addPropertyChangeListener(new PropertyChangeListener() {
                        @Override
                        public void propertyChange(PropertyChangeEvent evt) {
                            if ("state".equals(evt.getPropertyName())) {

                                SwingWorker.StateValue state = (SwingWorker.StateValue) evt.getNewValue();
                                switch (state) {
                                    case DONE:
                                        startButton.setEnabled(true);
                                        break;
                                    case STARTED:
                                        pb.setValue(0);
                                        break;
                                }

                            } else if ("progress".equals(evt.getPropertyName())) {

                                int progress = (Integer)evt.getNewValue();
                                pb.setValue(progress);

                            }
                        }
                    });
                    worker.execute();
                }
            });

        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

    }

    public class ProgressWorker extends SwingWorker {

        @Override
        protected Object doInBackground() throws Exception {

            int max = 1000;
            for (int index = 0; index < max; index++) {

                int progress = Math.round(((float)index / (float)max) * 100f);
                setProgress(progress);
                Thread.sleep(16);

            }
            return null;
        }

    }

}