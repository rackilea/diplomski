PImage bg;

void settings() {
  size(800, 800);
}

void setup() { 
  bg = loadImage("rot.png");
}

void draw() {
  background(bg);
}