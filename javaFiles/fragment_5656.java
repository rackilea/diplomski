import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class ReadFile {

    public static void main(String[] args) {
        new ReadFile();
    }

    public ReadFile() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                final JProgressBar pb = new JProgressBar(0, 100);
                final ReadFileWorker worker = new ReadFileWorker();
                worker.addPropertyChangeListener(new PropertyChangeListener() {
                    @Override
                    public void propertyChange(PropertyChangeEvent evt) {
                        if ("progress".equalsIgnoreCase(evt.getPropertyName())) {
                            pb.setValue(worker.getProgress());
                        }
                    }
                });

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new GridBagLayout());
                frame.add(pb);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                worker.execute();
            }
        });
    }

    public class ReadFileWorker extends SwingWorker<List<String>, String> {

        @Override
        protected List<String> doInBackground() throws Exception {
            List<String> lines = new ArrayList<>(25);
            File textFile = new File("Test.txt");
            long byteLength = textFile.length();

            System.out.println("Reading " + byteLength + " bytes...");

            try (InputStream is = new FileInputStream(textFile)) {

                byte[] content = new byte[1024];
                int bytesRead = -1;
                long totalBytes = 0;
                String lastText = "";
                while ((bytesRead = is.read(content)) != -1) {

                    totalBytes += bytesRead;
                    setProgress(Math.round(((float) totalBytes / (float) byteLength) * 100f));

                    String text = lastText + new String(content);
                    boolean keepEnd = !text.endsWith("\n");
                    String[] parts = text.split("\n");

                    for (int count = 0; count < (keepEnd ? parts.length - 1 : parts.length); count++) {
                        lines.add(parts[count]);
                        publish(parts[count]);
                    }

                    if (keepEnd) {
                        lastText = parts[parts.length - 1];
                    } else {
                        lastText = "";
                    }

                    // This is only here to slow the demonstration down
                    Thread.sleep(5);

                }

                System.out.println("Read " + totalBytes + " bytes...");
                System.out.println("Read " + lines.size() + " lines...");

            } finally {

            }

            return lines;
        }

        @Override
        protected void done() {
            try {
                List<String> lines = get();
            } catch (InterruptedException | ExecutionException ex) {
                ex.printStackTrace();
            }
        }

    }

}