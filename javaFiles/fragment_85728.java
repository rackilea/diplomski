import ddf.minim.spi.*;
import ddf.minim.signals.*;
import ddf.minim.*;
import ddf.minim.analysis.*;
import ddf.minim.ugens.*;
import ddf.minim.effects.*;
import java.io.File;
import java.io.FilenameFilter;


color waveColor;
int waveIncr = 0;
int counter = 0;
int songCounter = 0;
int fadeLevel = 10;


float buttonX;
float buttonY;
float buttonW;
float buttonH;

Minim minim;
AudioPlayer player;
FFT fft;
ArrayList<Songs> s;
int k;

String filename;

boolean isSelected = false;

void setup() {

  s = new ArrayList();

  textSize(24);

  frame.setResizable(false);

  background(255);

  size(600, 600);

  fill(0);
  stroke(0);
  noFill();

  buttonW = 200;
  buttonH = 50;
  buttonX = width - width/2 - buttonW/2;
  buttonY = height/2 - buttonH/2;

  // Minim stuff
  minim = new Minim(this);
}

void draw() {

  background(255);
  fill(0);

  rectMode(CORNER);

  rect(buttonX, buttonY, buttonW, buttonH);

  fill(255);

  textAlign(LEFT);
  text("Import File", buttonX+35, buttonY+30);

  if (isSelected) {
    // s.get(k).waveform();
    s.get(k).wavewave();
  }
}

void mouseClicked() {
  if (mouseX>buttonX && mouseX < buttonX+buttonW && mouseY > buttonY && mouseY < buttonY+buttonH) {
    selectInput("Import music file", "fileSelected");
  }
}

/* Taken from Processing.org */
void fileSelected(File selection) {
  if (selection == null) {
    println("Window was closed or user hit cancel");
  } 
  else {
    filename = selection.getAbsolutePath();
    s.add(new Songs(player, filename, "Filename"));
    isSelected = true;
  }
}

// stop minim and the player.
void stop() {
  player.close();
  minim.stop();
  super.stop();
}

class Songs {
  AudioPlayer song; 
  String directory;
  String songName;
  Songs(AudioPlayer song, String directory, String songName) {

    song=minim.loadFile(directory);    

    this.song=song;
    this.songName=songName;
    song.play();


    fft = new FFT(song.bufferSize(), song.sampleRate());
  }

  void wavewave() {
    //DRAW FFT
    fft.forward(song.mix);
    colorMode(HSB, 255);

    float spread = map(450, 0, width, 1, 21.5);
    float x = 0;
    for (int i = 0; i < song.sampleRate() && x < width; i += spread)
    {
      x = i/spread;
      stroke(map(fft.getFreq(i), 0, 256, 0, 360) * 2, //Hue
      255, //Saturation
      255); //Brightness
      line(x, 512, x, 512 - fft.getFreq(i) * 4);
    }
    //map(value, minimum1, maximum1, minimum2, maximum2);

    x = 0;
    for (int i = 0; i < song.sampleRate() && x < width; i += spread)
    {
      x = i/spread;
      stroke(map(fft.getFreq(i), 0, 256, 0, 360) * 2, //Hue
      255, //Saturation
      255); //Brightness
      line(x, 512, x, 512 + fft.getFreq(i) * 4);
    }
  }
}