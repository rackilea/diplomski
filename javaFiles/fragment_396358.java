import java.applet.AudioClip;
import javax.swing.JApplet;

@SuppressWarnings("serial")
public class audioPlayer extends JApplet{

    AudioClip aClip;

    public void init(){
        System.out.print("Getting audio clip!");
        aClip = getAudioClip(getCodeBase(), "tetris.wav");
        System.out.print("Looping audio clip!");
        aClip.loop();
    }

}