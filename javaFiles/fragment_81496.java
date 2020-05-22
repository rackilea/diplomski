public class App {
private final static String pathToFile = "D:\\TarsosWavTest\\wavs\\1000HzTone.wav";
private final static int audioBufferSize = 2048;
private final static int bufferOverlap = 1024;
private final static int amountOfMelFilters = 20;
private final static int amountOfCepstrumCoef = 30;
private final static float lowerFilterFreq = 133.33f;
private final static float upperFilterFreq = 8000f;

public static void main(String[] args) {
    File file = new File(pathToFile);
    AudioInputStream audioInputStream;
    byte[] byteAudioArray;
    AudioDispatcher audioDispatcher;

    try {
        audioInputStream = AudioSystem.getAudioInputStream(file);
        byteAudioArray = audioInputStream.readAllBytes();
    } catch (Exception e) {
        System.out.println("Exception occured");
        e.printStackTrace();
        return;
    }

    try {
        audioDispatcher = AudioDispatcherFactory.fromByteArray(byteAudioArray, audioInputStream.getFormat(),
                audioBufferSize, bufferOverlap);
    } catch (Exception e) {
        e.printStackTrace();
        return;
    }

    final MFCC mfccProcessor = new MFCC(audioBufferSize, audioInputStream.getFormat().getSampleRate(),
            amountOfCepstrumCoef, amountOfMelFilters, lowerFilterFreq, upperFilterFreq);

    audioDispatcher.addAudioProcessor(mfccProcessor);
    audioDispatcher.addAudioProcessor(new AudioProcessor() {

        @Override // gets called on each audio frame
        public boolean process(AudioEvent audioEvent) {
            float[] mfccs = mfccProcessor.getMFCC();
            /*  do whatever necessary with the mfcc elements here
                e.g print them  */
            //System.out.println(Arrays.toString(mfccs));
            return true;
        }

        @Override // gets called when end of the audio file was reached
        public void processingFinished() {
            System.out.println("end of file reached");
        }
    });
    audioDispatcher.run();// starts a new thread

}}