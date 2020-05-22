public void playSoundOldJava(String soundFile)
{
    try {
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(soundFile);

        // TODO: add check for null inputsteam
        if (is == null) {
            throw new IOException("did not find " + soundFile);
        }

        AudioInputStream ais = AudioSystem.getAudioInputStream(is);

        DataLine.Info dataInfo = new DataLine.Info(Clip.class, ais.getFormat());

        if (AudioSystem.isLineSupported(dataInfo)) {
            Clip clip = (Clip)AudioSystem.getLine(dataInfo);
            System.out.println("open");
            clip.open(ais);

            clip.start();
            do {
                try {
                    Thread.sleep(50);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            while (clip.isActive());                  

        }
    }
    catch (Exception e) {
        e.printStackTrace();
    }
}