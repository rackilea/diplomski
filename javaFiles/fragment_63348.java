import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
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

        public TestPane() {
            setLayout(new GridBagLayout());
            JLabel label = new JLabel("...");
            add(label);

            TickerWorker worker = new TickerWorker();
            worker.addPropertyChangeListener(new PropertyChangeListener() {
                @Override
                public void propertyChange(PropertyChangeEvent evt) {
                    System.out.println(evt.getPropertyName());
                    if ("counter".equals(evt.getPropertyName())) {
                        long value = (long) evt.getNewValue();
                        label.setText(Long.toString(value));
                    }
                }
            });
            worker.execute();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

    }

    public class TickerWorker extends SwingWorker<Void, Long> {

        @Override
        protected Void doInBackground() throws Exception {
            long counter = 0;
            while (true) {
                Thread.sleep(1000);
                publish(++counter);
            }
        }

        @Override
        protected void process(List<Long> chunks) {
            // Since we're in the EDT, it's probably pointless do announce ALL the
            // values, we're probably only interested in the last one
            for (long value : chunks) {
                firePropertyChange("counter", value - 1, value);
            }
        }
    }

}