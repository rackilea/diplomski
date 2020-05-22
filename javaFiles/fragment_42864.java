import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

public class Demo {

    private void createAndShowGUI() {

        final JTextArea textArea = new JTextArea(20, 50);

        final PausableSwingWorker<Void, String> worker = new PausableSwingWorker<Void, String>() {
            @Override
            protected Void doInBackground() throws Exception {
                while (!isCancelled()) {
                    if (!isPaused()) {
                        publish("Writing...");
                    } else {
                        Thread.sleep(200);
                    }
                }
                return null;
            }

            @Override
            protected void process(List<String> chunks) {
                String text = String.format("%s%n", chunks.get(chunks.size() - 1));
                textArea.append(text);
            }
        };

        worker.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if ("paused".equals(evt.getPropertyName())) {
                    String text = (Boolean)evt.getNewValue() ? "Paused..." : "Resumed...";
                    textArea.append(String.format("%s%n", text));
                }
            }
        });

        Action pause = new AbstractAction("Pause") {
            @Override
            public void actionPerformed(ActionEvent e) {
                worker.pause();
            }
        };

        Action resume = new AbstractAction("Resume") {
            @Override
            public void actionPerformed(ActionEvent e) {
                worker.resume();
            }
        };

        Action stop = new AbstractAction("Stop") {
            @Override
            public void actionPerformed(ActionEvent e) {
                worker.cancel(true);
            }
        };

        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonsPanel.add(new JButton(pause));
        buttonsPanel.add(new JButton(resume));
        buttonsPanel.add(new JButton(stop));

        JPanel content = new JPanel(new BorderLayout(8, 8));
        content.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
        content.add(new JScrollPane(textArea), BorderLayout.CENTER);
        content.add(buttonsPanel, BorderLayout.SOUTH);

        JFrame frame = new JFrame("Demo");
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (!worker.isDone()) {
                    worker.cancel(true);
                }
                e.getWindow().dispose();
            }
        });

        frame.add(content);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);

        worker.execute();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Demo().createAndShowGUI();
            }
        });
    }

    abstract class PausableSwingWorker<K, V> extends SwingWorker<K, V> {

        private volatile boolean isPaused;

        public final void pause() {
            if (!isPaused() && !isDone()) {
                isPaused = true;
                firePropertyChange("paused", false, true);
            }
        }

        public final void resume() {
            if (isPaused() && !isDone()) {
                isPaused = false;
                firePropertyChange("paused", true, false);
            }
        }

        public final boolean isPaused() {
            return isPaused;
        }
    }
}