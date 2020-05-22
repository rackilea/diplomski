PGraphics pg;

void setup() {
  size(200, 200, P2D);
  pg = createGraphics(100, 100, P3D);
}

void draw() {
  pg.beginDraw();
  pg.background(0);
  pg.noStroke();
  pg.translate(pg.width*0.5, pg.height*0.5);
  pg.lights();
  pg.sphere(25);
  pg.endDraw();

  background(0, 0, 255);
  image(pg, 50, 50); 
}