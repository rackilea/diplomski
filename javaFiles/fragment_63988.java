import java.awt.*;
import java.awt.image.*;
import java.io.*;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * @see http://stackoverflow.com/questions/4530659 */
public class WorkerTest extends JFrame {

    private JPanel panel = new JPanel();
    private JLabel label = new JLabel("Loading...");

    public WorkerTest() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.CENTER);
        this.add(label);
        this.pack();
        this.setLocationRelativeTo(null);
    }

    private void start() {
        new ImageWorker().execute();
    }

    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                WorkerTest wt = new WorkerTest();
                wt.setVisible(true);
                wt.start();
            }
        });
    }

    class ImageWorker extends SwingWorker<File, Void> {

        private static final String TEST =
            "http://cdn.sstatic.net/stackexchange/img/logos/so/so-logo.png";
        private BufferedImage image;
        private File file;

        @Override
        protected File doInBackground() throws IOException {
            image = ImageIO.read(new URL(TEST));
            file = File.createTempFile("image", null);
            ImageIO.write(image, "png", file);
            return file;
        }

        @Override
        protected void done() {
            label.setText("<html><body><img src=\"file://"
                + file.getAbsolutePath() + "\"/></body></html>");
            panel.setPreferredSize(new Dimension(image.getWidth(), image.getHeight()));
            WorkerTest.this.pack();
            WorkerTest.this.setLocationRelativeTo(null);
        }
    }
}