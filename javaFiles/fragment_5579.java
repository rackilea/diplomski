import javax.sound.sampled.*;

AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
    new File("some_file.wav"));
Clip clip = AudioSystem.getClip();
clip.open(audioInputStream);
FloatControl gainControl = 
    (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
gainControl.setValue(-10.0f); // Reduce volume by 10 decibels.
clip.start();