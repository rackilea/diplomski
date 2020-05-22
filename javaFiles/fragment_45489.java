import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
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
            File[] musicFiles = new File("...").listFiles(new FileFilter() {
                @Override
                public boolean accept(File pathname) {
                    return pathname.getName().toLowerCase().endsWith(".wav");
                }
            });

            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.fill = GridBagConstraints.HORIZONTAL;

            for (File music : musicFiles) {
                try {
                    JButton btn = new JButton(new AudioAction(music.getName(), music.toURI().toURL()));
                    add(btn, gbc);
                } catch (MalformedURLException exp) {
                    exp.printStackTrace();
                }
            }

        }

    }

    public class AudioAction extends AbstractAction {

        private AudioPlayer player;

        public AudioAction(String name, URL audioSource) {
            super(name);
            player = new AudioPlayer(audioSource);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (player.isPlaying()) {
                player.stop();
            } else {
                try {
                    player.play();
                } catch (IOException | LineUnavailableException | UnsupportedAudioFileException ex) {
                    ex.printStackTrace();
                }
            }
        }

    }

    public class AudioPlayer {

        private Clip clip;
        private URL url;

        public AudioPlayer(URL url) {
            this.url = url;
        }

        public boolean isPlaying() {
            return clip != null && clip.isRunning();
        }

        protected void open() throws IOException, LineUnavailableException, UnsupportedAudioFileException {
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(url.openStream()));
        }

        public void play() throws IOException, LineUnavailableException, UnsupportedAudioFileException {
            if (clip == null || !clip.isRunning()) {
                open();
                clip.setFramePosition(0);
                clip.start();
            }
        }

        public void stop() {
            if (clip != null && clip.isRunning()) {
                clip.stop();
                clip.flush();
                dispose();
            }
        }

        public void dispose() {
            try {
                clip.close();
            } finally {
                clip = null;
            }
        }

    }

}