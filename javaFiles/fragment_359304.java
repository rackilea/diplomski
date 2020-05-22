public class A {    
    @Test
    public void testAudioInputStream() throws UnsupportedAudioFileException, IOException {
        InputStream stream = A.class.getResourceAsStream("/result.wav");
        System.out.println(stream != null);
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(stream);
        System.out.println(audioInputStream != null);
    }    
}