import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Mixer;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.TargetDataLine;

public class Audio {

boolean stopCapture = false;
ByteArrayOutputStream byteArrayOutputStream;
AudioFormat audioFormat;
TargetDataLine targetDataLine;
AudioInputStream audioInputStream;
SourceDataLine sourceDataLine;
byte tempBuffer[] = new byte[500];

public static void main(String[] args) {
    Audio audio = new Audio();
    audio.captureAudio();

}

private AudioFormat getAudioFormat() {
    float sampleRate = 8000.0F;
    int sampleSizeInBits = 16;
    int channels = 1;
    boolean signed = true;
    boolean bigEndian = true;
    return new AudioFormat(sampleRate, sampleSizeInBits, channels, signed, bigEndian);
}

private void captureAudio() {
    try {

        /* ~~~~~ UPDATE THIS PART OF CODE ~~~~~*/

        Mixer.Info[] mixerInfo = AudioSystem.getMixerInfo();    //get available mixers
        System.out.println("Available mixers:");
        for (int cnt = 0; cnt < mixerInfo.length; cnt++) {
            System.out.println(mixerInfo[cnt].getName());
        }
        audioFormat = getAudioFormat();     //get the audio format

        DataLine.Info dataLineInfo = new DataLine.Info(TargetDataLine.class, audioFormat);

        Mixer mixer = AudioSystem.getMixer(mixerInfo[3]);   //getting the mixer for capture device

        /* ~~~~~ UPDATE THIS PART OF CODE ~~~~~*/ 

        targetDataLine = (TargetDataLine) mixer.getLine(dataLineInfo);
        targetDataLine.open(audioFormat);
        targetDataLine.start();

        DataLine.Info dataLineInfo1 = new DataLine.Info(SourceDataLine.class, audioFormat);
        sourceDataLine = (SourceDataLine) AudioSystem.getLine(dataLineInfo1);
        sourceDataLine.open(audioFormat);
        sourceDataLine.start();

        Thread captureAndPlayThread = new captureAndPlayThread();   //thread to capture and play audio
        captureAndPlayThread.start();

    } catch (LineUnavailableException e) {
        System.out.println(e);
        System.exit(0);
    }
}

class captureAndPlayThread extends Thread {

    @Override
    public void run() {
        byteArrayOutputStream = new ByteArrayOutputStream();
        stopCapture = false;
        try {
            int readCount;
            while (!stopCapture) {
                readCount = targetDataLine.read(tempBuffer, 0, tempBuffer.length);  //capture sound into tempBuffer
                if (readCount > 0) {
                    byteArrayOutputStream.write(tempBuffer, 0, readCount);
                    sourceDataLine.write(tempBuffer, 0, 500);   //playing audio available in tempBuffer
                }
            }
            byteArrayOutputStream.close();
        } catch (IOException e) {
            System.out.println(e);
            System.exit(0);
        }
    }
}

}