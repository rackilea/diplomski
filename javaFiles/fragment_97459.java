Thing thing1;
Thing thing2;

void setup(){
  size(300,300);
  smooth();
  thing1 = new Thing(1*width/3,height/2,false);
  thing2 = new Thing(2*width/3,height/2,true);
}
void draw(){
  background(100);
  stroke(0);
  line(100,100,250,250);
  line(150,100,300,250);
  thing1.display();
  thing2.display();
}

class Thing
{
  PVector loc;
  boolean glowing;
  Thing(int x, int y, boolean glow){
    loc = new PVector(x,y);
    glowing = glow;
  }
  void display(){
    if(glowing){
      //float glowRadius = 100.0;
      float glowRadius = 100.0 + 15 * sin(frameCount/(3*frameRate)*TWO_PI); 
      strokeWeight(2);
      fill(255,0);
      for(int i = 0; i < glowRadius; i++){
        stroke(255,255.0*(1-i/glowRadius));
        ellipse(loc.x,loc.y,i,i);
      }
    }
    //irrelevant
    stroke(0);
    fill(0);
    ellipseMode(CENTER);
    ellipse(loc.x,loc.y,40,40);
    stroke(0,255,0);
    line(loc.x,loc.y+30,loc.x,loc.y-30);
    line(loc.x+30,loc.y,loc.x-30,loc.y);
  }
}