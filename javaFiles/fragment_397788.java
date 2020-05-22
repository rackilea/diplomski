import javax.sound.sampled.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException, 
UnsupportedAudioFileException, LineUnavailableException {
    JFileChooser chooser = new JFileChooser();
    chooser.showOpenDialog(null);
    String path = chooser.getSelectedFile().getAbsolutePath();

    System.err.println(path);
    File file = new File(path);

    AudioInputStream baseStream = AudioSystem.getAudioInputStream(file);

    AudioFormat baseFormat = baseStream.getFormat();

    System.err.println(baseFormat.toString());
    AudioFormat format = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, 
baseFormat.getSampleRate(),
            16, baseFormat.getChannels(), baseFormat.getChannels() * 2, 
baseFormat.getSampleRate(), true);

    DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);

    AudioInputStream stream = AudioSystem.getAudioInputStream(format, baseStream);

    SourceDataLine audioLine = (SourceDataLine) AudioSystem.getLine(info);


    audioLine.open(format);
    audioLine.start();

    FloatControl pan = (FloatControl) audioLine.getControl(FloatControl.Type.PAN);

    pan.setValue(1);

    int BUFFER_SIZE = 4096;

    byte[] buffer = new byte[BUFFER_SIZE];

    int read = -1;

    while((read = stream.read(buffer)) != -1){
        audioLine.write(buffer, 0, read);
    }

    audioLine.drain();
    audioLine.close();
}
}