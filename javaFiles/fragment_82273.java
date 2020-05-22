import  sun.audio.*;
import  java.io.*;

public class Sound {

    private InputStream input;
    private AudioStream audio;

    public Sound (File fileName)
    {
        input = new FileInputStream();
        audio = new AudioStream(input);
    }

    public void play()
    {
        AudioPlayer.player.start(audio);
    }

    public void stop()
    {
        AudioPlayer.player.stop(audio);
    }

}