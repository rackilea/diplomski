PVector p = new PVector(100, 100); //Position
PVector v = new PVector(0, 0);     //Velocity
PVector dir;                       //Direction
int sizeX = 600, sizeY = 600;      //Window size
int rectX = 250, rectY = 250;      //Rectangle position
int rectW = 200, rectH = 100;      //Rectangle size
int ballR = 10;                    //Ball radius
int gap = 2;                       //Corner gap

void setup(){
  size(sizeX, sizeY);
  frameRate(120);
}

void draw(){
  background(0);
  rect(rectX, rectY, rectW, rectH);
  dir = new PVector(mouseX, mouseY);
  v = PVector.sub(dir, p);
  if((v.x>0 && p.x+ballR > rectX         && p.x+ballR < rectX + rectW &&
               p.y+ballR > rectY + gap   && p.y-ballR < rectY + rectH - gap)
   ||(v.x<0 && p.x-ballR < rectX + rectW && p.x-ballR > rectX &&
               p.y+ballR > rectY + gap   && p.y-ballR < rectY + rectH - gap)){
      v.x = -v.x;
  } 
  if((v.y>0 && p.y+ballR > rectY         && p.y+ballR < rectY + rectH && 
               p.x+ballR > rectX + gap   && p.x-ballR < rectX + rectW - gap)
   ||(v.y<0 && p.y-ballR < rectY + rectH && p.y-ballR > rectY &&
               p.x+ballR > rectX + gap   && p.x-ballR < rectX + rectW - gap)){
      v.y = -v.y;
  }
  v.setMag(2.5);
  p.add(v);
  ellipse(p.x, p.y, 2*ballR, 2*ballR);
}