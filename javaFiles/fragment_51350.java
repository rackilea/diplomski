// Generate bang noise data
// Sourced from http://www.rgagnon.com/javadetails/java-0632.html
public static byte[] bang() {
    byte[] buf = new byte[8050];
    Random r = new Random();
    boolean silence = true;
    for (int i = 0; i < 8000; i++) {
        while (r.nextInt() % 10 != 0) {
            buf[i] =
                    silence ? 0
                    : (byte) Math.abs(r.nextInt()
                    % (int) (1. + 63. * (1. + Math.cos(((double) i)
                    * Math.PI / 8000.))));
            i++;
        }
        silence = !silence;
    }
    return buf;
}


private static void save(byte[] data, String filename) throws IOException, LineUnavailableException, UnsupportedAudioFileException {
    InputStream byteArray = new ByteArrayInputStream(data);
    AudioInputStream ais = new AudioInputStream(byteArray, getAudioFormat(), (long) data.length);
    AudioSystem.write(ais, AudioFileFormat.Type.WAVE, new File(filename));
}

private static AudioFormat getAudioFormat() {
    return new AudioFormat(
            8000f, // sampleRate
            8, // sampleSizeInBits
            1, // channels
            true, // signed
            false);      // bigEndian  
}

public static void main(String[] args) throws Exception {
    byte[] data  = bang();
    save(data, "test.wav");
}