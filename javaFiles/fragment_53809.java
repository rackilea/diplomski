import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class AudioPlayer {
    public static void playAudio() {
        AudioInputStream audioIn;
        try {
            audioIn = AudioSystem.getAudioInputStream(AudioPlayer.class.getResourceAsStream("/audio/file.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException  e) {
            e.printStackTrace();
        }
    }

}