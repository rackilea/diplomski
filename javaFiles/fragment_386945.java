import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

public class Demo {

    private void createAndShowGUI() {

        final JProgressBar progressBar = new JProgressBar();
        progressBar.setStringPainted(true);
        progressBar.setString("");

        final SwingWorker<Void,String> worker = new SwingWorker<Void, String>() {
            @Override
            protected Void doInBackground() throws Exception {

                long totalSize = 0l;

                File[] files = new File(System.getProperty("user.dir")).listFiles();
                for (File file : files) {
                    totalSize += file.length();
                }

                long transferred = 0l;

                for (File file : files) {                    
                    Thread.sleep(250); // Just for animation purpose
                    transferred += file.length();
                    int progress = (int) (transferred * 100l / totalSize);
                    setProgress(progress);

                    String text = String.format("%1s%%: %2s / %3s bytes", progress, transferred, totalSize);
                    publish(text);
                }

                return null;
            }

            @Override
            protected void process(List<String> chunks) {
                progressBar.setString(chunks.get(chunks.size() - 1));
            }
        };

        worker.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if ("progress".equals(evt.getPropertyName())) {
                    progressBar.setValue((Integer)evt.getNewValue());
                }
            }
        });

        Action startAction = new AbstractAction("Start") {
            @Override
            public void actionPerformed(ActionEvent e) {
                worker.execute();
                setEnabled(false);
            }
        };

        JPanel content = new JPanel();
        content.add(progressBar);
        content.add(new JButton(startAction));

        JFrame frame = new JFrame("Demo");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(content);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Demo().createAndShowGUI();
            }
        });
    }    
}