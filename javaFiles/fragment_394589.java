import java.awt.EventQueue;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.swing.JOptionPane;

/**
 * @see https://stackoverflow.com/questions/7803310
 * @see https://stackoverflow.com/questions/2065693
 */
public class Tone {

    public static void main(String[] args) throws LineUnavailableException {
        final AudioFormat af =
            new AudioFormat(Note.SAMPLE_RATE, 8, 1, true, true);
        final SourceDataLine line = AudioSystem.getSourceDataLine(af);
        EventQueue.invokeLater(new Runnable() {

            public void run() {
                JOptionPane.showMessageDialog(null, "Halt");
                //line.stop(); // stops and hangs on drain
                line.close();
            }
        });
        line.open(af, Note.SAMPLE_RATE);
        line.start();
        for (Note n : Note.values()) {
            play(line, n, 500);
            play(line, Note.REST, 10);
        }
        line.drain();
        line.close();
    }

    private static void play(SourceDataLine line, Note note, int ms) {
        ms = Math.min(ms, Note.SECONDS * 1000);
        int length = Note.SAMPLE_RATE * ms / 1000;
        int count = line.write(note.data(), 0, length);
    }
}