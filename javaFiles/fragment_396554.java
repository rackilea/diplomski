import processing.core.PApplet;

import ddf.minim.Minim;
import ddf.minim.AudioPlayer;
import ddf.minim.AudioInput;

public class Test {

  Minim minim;
  AudioPlayer player;
  AudioInput input;

  public Test(PApplet sketch) {
    minim = new Minim(sketch);
    player = minim.loadFile("song.mp3");
    input = minim.getLineIn();
  }
}