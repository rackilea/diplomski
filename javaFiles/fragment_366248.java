import processing.video.*;
Movie movie;

int videoScale = 8;
int cols, rows;
PGraphics resized;

void setup() {
  size(640, 360);
  background(0);
  noSmooth();//remove aliasing

  movie = new Movie(this, "transit.mov");
  movie.loop();

  cols = width / videoScale;
  rows = height / videoScale;

  //setup a smaller sized buffer to draw into
  resized = createGraphics(cols, rows);
  resized.beginDraw();
  resized.noSmooth();//remove aliasing
  resized.endDraw();
}

void draw() {
  //draw video resized smaller into a buffer
  resized.beginDraw();
  resized.image(movie,0,0,cols,rows);
  resized.endDraw();
  //draw the small buffer resized bigger
  image(resized,0,0,movie.width,movie.height);
}

// Called every time a new frame is available to read
void movieEvent(Movie movie) {
  movie.read();
}