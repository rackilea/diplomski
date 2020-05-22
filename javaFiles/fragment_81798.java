private Mixer.Info getSpeakers()
{
    Mixer.Info speakers = null;
    Mixer.Info[] mixerInfo = AudioSystem.getMixerInfo();
    for (Mixer.Info mi : mixerInfo) {
        // System.out.println(mi.getName() + "\t" +
        // mi.getDescription());

        if (mi.getName().startsWith("Speakers")) {
            speakers = mi;
        }
    }

    System.out.println(
            (speakers != null ? speakers.getName() : "<no speakers>"));

    return speakers;
}    

public void playSound(String soundFile)
{
    AudioInputStream ais = null;        
    try {
        URL url = new File(soundFile).toURI().toURL();

        ais = AudioSystem.getAudioInputStream(url);

        Mixer mixer = AudioSystem.getMixer(getSpeakers());

        DataLine.Info dataInfo = new DataLine.Info(Clip.class, null);

        Clip clip = (Clip)mixer.getLine(dataInfo);

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
    catch (UnsupportedAudioFileException | IOException |
            LineUnavailableException e) 
    {
        e.printStackTrace();
    }        
}