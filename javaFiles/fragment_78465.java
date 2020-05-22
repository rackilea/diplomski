File soundFile = new File("/usr/share/sounds/generic.wav");
Clip clip = AudioSystem.getClip();
AudioInputStream inputStream = AudioSystem.getAudioInputStream(soundFile);
clip.open(inputStream);

while (System.in.read() == '\n') {
    clip.stop();
    clip.setFramePosition(0);
    clip.start();
}