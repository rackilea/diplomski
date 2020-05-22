import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame();
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        public TestPane() {
            setLayout(new GridBagLayout());

            JButton workButton = new JButton("Do some work already");
            add(workButton);

            workButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    workButton.setEnabled(false);
                    ProgressPane progressPane = new ProgressPane();
                    // This is a dangrous kind of thing to do and you should
                    // check that the result is a JFrame or JDialog first
                    JFrame parent = (JFrame) SwingUtilities.windowForComponent(TestPane.this);
                    parent.setGlassPane(progressPane);
                    progressPane.setVisible(true);
                    // This is a little bit of overkill, but it allows time
                    // for the component to become realised before we try and
                    // steal focus...
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            progressPane.requestFocusInWindow();
                        }
                    });
                    Worker worker = new Worker();
                    worker.addPropertyChangeListener(new PropertyChangeListener() {
                        @Override
                        public void propertyChange(PropertyChangeEvent evt) {
                            if ("state".equals(evt.getPropertyName())) {
                                if (worker.getState() == SwingWorker.StateValue.DONE) {
                                    progressPane.setVisible(false);
                                    workButton.setEnabled(true);
                                }
                            } else if ("progress".equals(evt.getPropertyName())) {
                                double value = (int) evt.getNewValue() / 100.0;
                                progressPane.progressChanged(value);
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

    public class Worker extends SwingWorker<Object, Object> {

        @Override
        protected Object doInBackground() throws Exception {
            for (int value = 0; value < 100; value++) {
                Thread.sleep(100);
                value++;
                setProgress(value);
            }
            return this;
        }

    }

    public interface ProgressListener {

        public void progressChanged(double progress);
    }

    public class ProgressPane extends JPanel implements ProgressListener {

        private JProgressBar pb;
        private JLabel label;

        private MouseAdapter mouseHandler = new MouseAdapter() {
        };
        private KeyAdapter keyHandler = new KeyAdapter() {
        };
        private FocusAdapter focusHandler = new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                if (isVisible()) {
                    requestFocusInWindow();
                }
            }
        };

        public ProgressPane() {
            pb = new JProgressBar(0, 100);
            label = new JLabel("Doing important work here...");

            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.insets = new Insets(8, 8, 8, 8);
            add(pb, gbc);
            add(label, gbc);

            setOpaque(false);
        }

        @Override
        public void addNotify() {
            super.addNotify();

            addMouseListener(mouseHandler);
            addMouseMotionListener(mouseHandler);
            addMouseWheelListener(mouseHandler);

            addKeyListener(keyHandler);

            addFocusListener(focusHandler);
        }

        @Override
        public void removeNotify() {
            super.removeNotify();

            removeMouseListener(mouseHandler);
            removeMouseMotionListener(mouseHandler);
            removeMouseWheelListener(mouseHandler);

            removeKeyListener(keyHandler);

            removeFocusListener(focusHandler);
        }

        @Override
        public void progressChanged(double progress) {
            pb.setValue((int) (progress * 100));
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setColor(new Color(128, 128, 128, 224));
            g2d.fillRect(0, 0, getWidth(), getHeight());
            g2d.dispose();
        }

    }

}