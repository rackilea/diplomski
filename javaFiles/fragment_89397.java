public static void playSound(String pathToMusicOnClasspath) {
    try {
        Clip clip = AudioSystem.getClip();
        clip.open(AudioSystem.getAudioInputStream(ClassLoader.getSystemResource(pathToMusicOnClasspath)));
        clip.start();
    } catch(Exception ignore) {}
}