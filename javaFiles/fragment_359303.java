public class Play{
    public AudioInputStream find(String s) throws UnsupportedAudioFileException, IOException{
        // Probably some try catch over the next statement to log the error if `result.wav` is not found.
        InputStream stream = Play.class.getResourceAsStream("/result.wav");
        return AudioSystem.getAudioInputStream(stream); 
    }
}