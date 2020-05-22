import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

http://www.tritonus.org/plugins.html

    public static void main(final String [] args) throws Exception {
        System.out.println("Running");        
        System.out.println(System.getProperty("java.version"));        
        final AudioFileFormat.Type [] types = AudioSystem.getAudioFileTypes();
        for (final AudioFileFormat.Type t : types) {
            System.out.println("Returning Type : " + t);
        } // End of the for //                
        final String PATH = "C:\\Users\\bbrown\\Downloads\\swing-hacks-examples-20060109\\Ch10-Audio\\75\\soundcloud2.mp3";             
        final File file = new File(PATH);
        final AudioInputStream in = AudioSystem.getAudioInputStream(new BufferedInputStream(new FileInputStream(file)));

        AudioInputStream din = null;
        final AudioFormat baseFormat = in.getFormat();
        final AudioFormat decodedFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED,
                baseFormat.getSampleRate(),
                16,
                baseFormat.getChannels(),
                baseFormat.getChannels() * 2,
                baseFormat.getSampleRate(),
                false);

        System.out.println("Channels : " + baseFormat.getChannels());                
        din = AudioSystem.getAudioInputStream(decodedFormat, in);        
        rawplay(decodedFormat, din);
        in.close();       
        System.out.println("Done");
    }    

    private static synchronized void rawplay(final AudioFormat targetFormat, final AudioInputStream din) throws IOException, LineUnavailableException {              
        final byte[] data = new byte[4096];
        final SourceDataLine line = getLine(targetFormat);               
        if (line != null) {
            System.out.println("Entering ...");
            // Start
            line.start();
            int nBytesRead = 0, nBytesWritten = 0;
            while (nBytesRead != -1) {
                nBytesRead = din.read(data, 0, data.length);
                if (nBytesRead != -1) {
                    nBytesWritten = line.write(data, 0, nBytesRead);
                    System.out.println("... -->" + data[0] + " bytesWritten:" + nBytesWritten);
                }                                           
            } // End of while //            
            System.out.println("Done ...");
            // Stop
            line.drain();
            line.stop();
            line.close();
            din.close();
        } // End of the if //
    }