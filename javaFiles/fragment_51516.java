Clip shoot;

private loadShootWav()
{
    AudioInputStream sample;
    sample = AudioSystem.getAudioInputStream(this.getClass().getResource("shoot.wav"));
    shoot = AudioSystem.getClip();
    shoot.open(sample);
}

public void playShootSFX()
{
    shoot.stop();
    shoot.setFramePosition(0);
    shoot.start(); 
}