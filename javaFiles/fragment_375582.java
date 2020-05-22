Clip clip = null;
ClassLoader cl = this.getClass().getClassLoader();
AudioInputStream ais;
URL url = cl.getResource("com/example/project/assets/TestSound.wav");
System.out.println(url);
try {
    ais = AudioSystem.getAudioInputStream(url);
clip = AudioSystem.getClip();
clip.open(ais);
}
catch (Exception e) {
    e.printStackTrace();
    System.exit(1);
}