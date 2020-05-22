try {
  audioInputStream=AudioSystem.getAudioInputStream(new File(".......wav"));

  System.out.println(audioInputStream.getFormat().getFrameSize());

} catch (Exception e) {
        e.printStackTrace();
}