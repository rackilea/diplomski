import java.net.URL;
import javax.swing.*;
import javax.sound.sampled.*;
import java.util.Scanner;

public class LoopSound {

    public static void main(String[] args) throws Exception {
        URL url = new URL(
            "http://pscode.org/media/leftright.wav");
        Clip clip = AudioSystem.getClip();
        // getAudioInputStream() also accepts a File or InputStream
        AudioInputStream ais = AudioSystem.
            getAudioInputStream( url );
        clip.open(ais);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
        Scanner scanner = new Scanner (System.in);
        scanner.nextInt();
    }
}