import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;
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
            File[] musicFiles = new File("a directory somewhere").listFiles(new FileFilter() {
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
                } catch (MalformedURLException ex) {
                    ex.printStackTrace();
                }
            }

        }

    }

    public class AudioAction extends AbstractAction {

        private URL audio;

        public AudioAction(String name, URL audioSource) {
            super(name);
            this.audio = audioSource;
        }

        public URL getAudioSource() {
            return audio;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            setEnabled(false);
            try (InputStream is = getAudioSource().openStream()) {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(is);
                Clip play = AudioSystem.getClip();
                play.addLineListener(new LineListener() {
                    @Override
                    public void update(LineEvent event) {
                        System.out.println(event.getFramePosition());
                        if (event.getType().equals(LineEvent.Type.STOP)) {
                            setEnabled(true);
                        }
                    }
                });
                play.open(audioInputStream);
                play.start();
            } catch (IOException | LineUnavailableException | UnsupportedAudioFileException exp) {
                exp.printStackTrace();
            }
        }

    }

}