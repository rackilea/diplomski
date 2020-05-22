package cz.speechtech.sound;

import org.urish.openal.ALException;
import org.urish.openal.Source;

import javax.sound.sampled.AudioFormat;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by honza on 16.12.15.
 */
public class OutputWriter extends Thread {
    private InputStream inputStream;
    private OutputStream outputStream;

    private int STREAMING_BUFFER_SIZE = 24000;
    private int NUMBER_OF_BUFFERS = 4;

    private boolean run = true;

    public OutputWriter(InputStream inputStream, Source source, AudioFormat audioFormat) {
        this.inputStream = inputStream;
        try {
            this.outputStream = source.createOutputStream(audioFormat, this.NUMBER_OF_BUFFERS, 1024);
        } catch (ALException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        byte[] buffer = new byte[this.STREAMING_BUFFER_SIZE];
        int i;
        try {
            Thread.sleep(1000); // Might cause problems
            while (this.run) {
                i = this.inputStream.read(buffer);
                if (i == -1) break;
                outputStream.write(buffer, 0, i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void stopRunning() {
        this.run = false;
        try {
            this.outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}