Thing thing1;

void setup(){
  size(300,300);
  background(0);
  thing1 = new Thing();
  thing1.display();
}
void draw(){}

class Thing
{
  PGraphics pg;
  Thing(){
    pg = createGraphics(200,200);
  }
  void display(){
    pg.beginDraw();
    pg.background(0,0);
    pg.strokeWeight(10);
    pg.stroke(255,100,0);
    pg.line(100,50,100,150);
    pg.line(75,50,125,50);
    pg.line(75,150,125,150);
    pg.line(30,100,170,100);
    pg.endDraw();
    PGraphics glow = createGraphics(200,200);
    glow.beginDraw();
    glow.image(pg,0,0);
    glow.loadPixels();
    glow.fill(255,3);
    glow.noStroke();
    //change the +=2 for different effects
    for(int x = 0; x < glow.width; x+=2){
      for(int y = 0; y < glow.height; y+=2){
        if(alpha(glow.pixels[y*glow.width+x]) != 0) glow.ellipse(x,y,40,40);
      }
    }

    glow.endDraw();
    //draw the glow:
    image(glow,50,50);
    //draw the sprite:
    image(pg,50,50);
  }
}