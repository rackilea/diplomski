import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.ImageWriter;
import javax.imageio.event.IIOReadProgressListener;
import javax.imageio.event.IIOWriteProgressListener;
import javax.imageio.stream.ImageInputStream;
import javax.imageio.stream.ImageOutputStream;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class ConvertImage {

    public static void main(String[] args) {
        new ConvertImage();
    }

    public ConvertImage() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                TestPane tp = new TestPane();

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(tp);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                tp.convert(new File("C:\\Users\\Shane Whitehead\\Dropbox\\Wallpapers\\animepaper.net_wallpaper_art_anime_aria_duanwu_festival_205050_wonderngo_7680x4800-a8aecc9c.jpg"));
            }
        });
    }

    public class TestPane extends JPanel implements ImageConverstionListener {

        private JLabel label = new JLabel("Waiting...");
        private JProgressBar pb = new JProgressBar();

        public TestPane() {
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            add(label, gbc);
            add(pb, gbc);
        }

        public void convert(File file) {
            ConverterWorker worker = new ConverterWorker(file, this);
            worker.addPropertyChangeListener(new PropertyChangeListener() {
                @Override
                public void propertyChange(final PropertyChangeEvent evt) {
                    if ("progress".equalsIgnoreCase(evt.getPropertyName())) {
                        pb.setValue((int) evt.getNewValue());
                    }
                }
            });
            worker.execute();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        @Override
        public void failedToConvertImage(File source, Throwable cause) {
            cause.printStackTrace();
            JOptionPane.showMessageDialog(this, "<html>Failed to convert " + source + "<br>" + cause.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        @Override
        public void imageConverted(File source, byte[] bytes) {
            JOptionPane.showMessageDialog(this, "Converted image to " + bytes.length + " bytes", "Converted", JOptionPane.INFORMATION_MESSAGE);
        }

        @Override
        public void setMessage(String msg) {
            label.setText(msg);
        }

    }

    public interface ImageConverstionListener {

        public void failedToConvertImage(File source, Throwable cause);

        public void imageConverted(File source, byte[] bytes);

        public void setMessage(String msg);

    }

    public class ConverterWorker extends SwingWorker<ByteArrayOutputStream, String> {

        private File source;
        private ImageConverstionListener listener;

        public ConverterWorker(File source, ImageConverstionListener listener) {
            this.source = source;
            this.listener = listener;
        }

        @Override
        protected void process(List<String> chunks) {
            listener.setMessage(chunks.get(chunks.size() - 1));
        }

        @Override
        protected ByteArrayOutputStream doInBackground() throws Exception {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            publish("Reading image...");
            try (ImageInputStream iis = ImageIO.createImageInputStream(source)) {
                Iterator<ImageReader> readers = ImageIO.getImageReaders(iis);
                if (readers.hasNext()) {
                    ImageReader reader = readers.next();
                    reader.addIIOReadProgressListener(new IIOReadProgressListener() {
                        @Override
                        public void sequenceStarted(ImageReader source, int minIndex) {
                        }

                        @Override
                        public void sequenceComplete(ImageReader source) {
                        }

                        @Override
                        public void imageStarted(ImageReader source, int imageIndex) {
                        }

                        @Override
                        public void imageProgress(ImageReader source, float percentageDone) {
                            setProgress(Math.round(percentageDone));
                        }

                        @Override
                        public void imageComplete(ImageReader source) {
                        }

                        @Override
                        public void thumbnailStarted(ImageReader source, int imageIndex, int thumbnailIndex) {
                        }

                        @Override
                        public void thumbnailProgress(ImageReader source, float percentageDone) {
                        }

                        @Override
                        public void thumbnailComplete(ImageReader source) {
                        }

                        @Override
                        public void readAborted(ImageReader source) {
                        }
                    });
                    reader.setInput(iis);
                    try {
                        BufferedImage img = reader.read(0);

                        publish("Converting image...");
                        try (ImageOutputStream ios = ImageIO.createImageOutputStream(baos)) {
                            Iterator<ImageWriter> writers = ImageIO.getImageWritersByFormatName("png");
                            if (writers.hasNext()) {
                                ImageWriter writer = writers.next();
                                writer.addIIOWriteProgressListener(new IIOWriteProgressListener() {
                                    @Override
                                    public void imageStarted(ImageWriter source, int imageIndex) {
                                    }

                                    @Override
                                    public void imageProgress(ImageWriter source, float percentageDone) {
                                        setProgress(Math.round(percentageDone));
                                    }

                                    @Override
                                    public void imageComplete(ImageWriter source) {
                                    }

                                    @Override
                                    public void thumbnailStarted(ImageWriter source, int imageIndex, int thumbnailIndex) {
                                    }

                                    @Override
                                    public void thumbnailProgress(ImageWriter source, float percentageDone) {
                                    }

                                    @Override
                                    public void thumbnailComplete(ImageWriter source) {
                                    }

                                    @Override
                                    public void writeAborted(ImageWriter source) {
                                    }
                                });

                                writer.setOutput(ios);
                                try {
                                    writer.write(img);
                                } finally {
                                    writer.removeAllIIOWriteProgressListeners();
                                }
                            }
                        }
                    } finally {
                        reader.removeAllIIOReadProgressListeners();
                    }
                }
            }
            return baos;
        }

        @Override
        protected void done() {
            try {
                ByteArrayOutputStream baos = get();
                listener.imageConverted(source, baos.toByteArray());
            } catch (InterruptedException | ExecutionException ex) {
                listener.failedToConvertImage(source, ex);
            }
        }

    }

}