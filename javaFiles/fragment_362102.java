import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.TargetDataLine;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TestMusic {

    public static void main(String[] args) {
        new TestMusic();
    }

    public TestMusic() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                Music.play("/play/some/music/white/boy");

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new JLabel("Look Ma, no hands"));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public static class Music {

        public static void play(final String url) {

            new Thread(new Runnable() {

                @Override
                public void run() {
                    new Music(url);
                }
            }).start();

        }

        private int total, totalToRead, numBytesRead, numBytesToRead;
        private byte[] buffer;
        private boolean stopped;
        private AudioFormat wav;
        private TargetDataLine line;
        private SourceDataLine lineIn;
        private DataLine.Info info;
        private File file;
        private FileInputStream fis;

        public Music(String url) {


            // AudioFormat(float sampleRate, int sampleSizeInBits,
            // int channels, boolean signed, boolean bigEndian)
            wav = new AudioFormat(44100, 16, 2, true, false);
            info = new DataLine.Info(SourceDataLine.class, wav);

            buffer = new byte[1024 * 333];
            numBytesToRead = 1024 * 333;
            total = 0;
            stopped = false;

            if (!AudioSystem.isLineSupported(info)) {
                System.out.print("no support for " + wav.toString());
            }
            try {
                // Obtain and open the line.
                lineIn = (SourceDataLine) AudioSystem.getLine(info);
                lineIn.open(wav);
                lineIn.start();
                fis = new FileInputStream(file = new File(url));
                totalToRead = fis.available();

                while (total < totalToRead && !stopped) {
                    numBytesRead = fis.read(buffer, 0, numBytesToRead);
                    if (numBytesRead == -1) {
                        break;
                    }
                    total += numBytesRead;
                    lineIn.write(buffer, 0, numBytesRead);
                }

            } catch (LineUnavailableException ex) {
                ex.printStackTrace();
            } catch (FileNotFoundException nofile) {
                nofile.printStackTrace();
            } catch (IOException io) {
                io.printStackTrace();
            }
        }
    }
}