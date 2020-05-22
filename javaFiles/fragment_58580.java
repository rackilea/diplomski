InputStream inaudio = getClass().getResourceAsStream("/audio/retrolevel.wav");
Clip clip = null;
try {
    clip = AudioSystem.getClip();
    clip.open(AudioSystem.getAudioInputStream(inaudio));
} catch (IOException | LineUnavailableException | UnsupportedAudioFileException e1) {
    e1.printStackTrace();
}
clip.start();