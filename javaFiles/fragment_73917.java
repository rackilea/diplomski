import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
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

        private JLabel label;

        public TestPane() {
            setLayout(new BorderLayout());
            label = new JLabel("Loading...");
            label.setHorizontalAlignment(JLabel.CENTER);
            label.setVerticalAlignment(JLabel.CENTER);
            add(label);
            ImageWorker worker = new ImageWorker(label);
            worker.execute();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(400, 400);
        }

        public class ImageWorker extends SwingWorker<Object, Image> {

            private JLabel output;

            public ImageWorker(JLabel output) {
                this.output = output;
            }

            @Override
            protected void process(List<Image> chunks) {
                output.setText(null);
                output.setIcon(new ImageIcon(chunks.get(chunks.size() - 1)));
            }

            @Override
            protected Object doInBackground() throws Exception {
                String meineURL = "http://www.pr0gramm.com/static/";

                URL url = new URL(meineURL);

                String quelltext = "";
                try (InputStreamReader isr = new InputStreamReader(url.openConnection().getInputStream()); BufferedReader br = new BufferedReader(isr)) {

                    // Kompletten Seiteninhalt auslesen
                    String line = "";

                    while ((line = br.readLine()) != null) {
                        quelltext += line + "\r\n";
                    }

                }

                String test = quelltext.substring(1708);
                String[] parts = test.split("<a href=");

                for (int i = 1; i < parts.length; i++) {
                    parts[i] = parts[i].substring(1, 15);
                }

                String[] viewable = new String[parts.length];

                for (int i = 1; i < (parts.length - 1); i++) {
                    String sitePath = "http://pr0gramm.com" + parts[i];

                    meineURL = sitePath;

                    url = new URL(meineURL);

                    try (InputStreamReader isr = new InputStreamReader(url.openConnection().getInputStream()); BufferedReader br = new BufferedReader(isr)) {

                        // Kompletten Seiteninhalt auslesen
                        String line = "";
                        quelltext = "";

                        while ((line = br.readLine()) != null) {
                            quelltext += line + "\r\n";
                        }

                        CharSequence picPath = quelltext.subSequence(quelltext.indexOf("//img.pr0gramm.com/"), quelltext.indexOf("//img.pr0gramm.com/") + 50);

                        viewable[i] = picPath.toString();

                    }
                }

                System.out.println("\nLink-Counter: " + viewable.length);

                for (int i = 1; i < viewable.length; i++) {
                    if (!(viewable[i].contains(".web"))) {
                        url = new URL("http:" + viewable[i]);

                        System.out.println("Reading " + url);
                        BufferedImage original = ImageIO.read(url);
                        Image image = original;

                        if (original.getWidth() > original.getHeight()) {
                            image = original.getScaledInstance(400, -1, Image.SCALE_SMOOTH);
                        } else {
                            image = original.getScaledInstance(-1, 400, Image.SCALE_SMOOTH);
                        }

                        publish(image);

                        System.out.println("test" + i);
                        Thread.sleep(5000);
                    }
                }

                return null;

            }

        }

    }

}