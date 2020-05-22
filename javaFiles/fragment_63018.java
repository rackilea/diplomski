// Developed in Eclipse, YMMV regarding resource location.
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

class ClipPlayer {

public static void main(String[] args) {
    // First, instantiate ourselves so we can call demoSam which
    // needs to be able to do a wait().
    ClipPlayer cp = new ClipPlayer();
    // Now run the actual demo
    cp.demoSam();
}

private void demoSam() {

    /**
     * Construct a Sam, capable of playing the "Chook.wav", a 0.1 sec sound.
     * NOTE: it's very tricky debugging an incorrectly-located
     * resource file, and I'm unable to give a general rule
     * here.  But in this example, Chook.wav is expected to be in the same
     * directory as the .class file, and there is no surrounding
     * package (i.e. we're taking the default package name).  If you
     * are using a package, you may have to write "myPackage/Chook.wav"
     * instead.
     */

    Sam sam;
    try {
        sam = new Sam("Chook.wav"); // or whatever, but it has to be .wav
    }
    catch (Exception e) {
        say("Exception thrown by Sam: " + e.getMessage());
        System.exit(1); // scoot
        return; // get rid of warning about sam possib not init'd
    }
    int countDown = 20;
    do {
        say("Doing something requiring accompanying sound effect...");
        try {
            sam.playIt();
        }
        catch (Exception e) {
            say("Caught exception from playIt: " + e.getMessage());
            System.exit(1);
        }

        // Now wait a human-scale duration, like 1/8 second.  In
        // practice we may be processing, since the sound is playing
        // asynchronously.

        synchronized (this) {
            try {
                wait(125); // wait 1/8 sec
            }
            catch (Exception e2) {
                say("huh?");
            }
        }
    } while (--countDown > 0);

}

/**
 * 'Sam' is a class that implements one method, playIt(), that simply
 * plays the .wav file clip it was instantiated with.  Just using an
 * inner class here for simplicity of demo.
 */
final class Sam {

    AudioInputStream ais;
    Clip             clip;

    /**
     * Constructor: prepare clip to be played. Do as much here as 
     * possible, to minimize the overhead of playing the clip, 
     * since I want to call the play() method 5-10 times a second.
     */
    Sam(String clipName) throws Exception {

        // Resource is in same directory as this source code.  
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        URL url = classLoader.getResource(clipName);
        ais = AudioSystem.getAudioInputStream(url);
        clip = AudioSystem.getClip();
        clip.open(ais);
    }

    /**
     * playIt(): Start the clip playing once, asynchronously, and exit. 
     */
    public void playIt() throws Exception {
        clip.setFramePosition(0);  // Must always rewind!
        clip.loop(0);
        clip.start();
    }
}

private static void say(String s) {
    System.out.println(s);
}
}