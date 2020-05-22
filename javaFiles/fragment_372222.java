public class ClipTest {

    public void run() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        InputStream inRequest = this.getClass().getResourceAsStream("batR.wav");
        AudioInputStream sound = AudioSystem.getAudioInputStream(inRequest);

        DataLine.Info info = new DataLine.Info(Clip.class, sound.getFormat());
        Clip clip = (Clip) AudioSystem.getLine(info);
        clip.open(sound);

        clip.addLineListener(new LineListener() {

            public void update(LineEvent event) {
                if(event.getType() == LineEvent.Type.STOP) {
                    event.getLine().close();
                    System.exit(0);
                }
            }
        });

        clip.start();

    }

    public static void main(String[] args) throws Exception {
        ClipTest clipTest = new ClipTest();
        clipTest.run();

    }
}