Prop myProp1;
Prop myProp2;
Prop myProp3;
Prop myProp4;
float angle;

void setup() {
  size(500, 500);
  background(255);
  angle = 0;
  fill(0);
  ellipseMode(CENTER);
  myProp1 = new Prop(50,50);
  myProp2 = new Prop(75,75);
  myProp3 = new Prop(100,100);
  myProp4 = new Prop(125,125);
}

void draw() {
  background(255);
  angle = ((angle + 0.1) % 360);
  myProp1.buildAndRotate(angle, width*3/4, height/4);
  myProp2.buildAndRotate(angle, width/4, height/4);
  myProp3.buildAndRotate(angle, width*3/4, height*3/4);
  myProp4.buildAndRotate(angle, width/4, height*3/4);
}

class Prop {
  int propX;
  int propY;
  int propW;
  int propH;

  Prop() {
    propX = 0;
    propY = 0;
    propW = 50;
    propH = 50;
  }

  Prop(int w, int h) {
    propX = 0;
    propY = 0;
    propW = w;
    propH = h;
  }

  void buildAndRotate(float angle, float moveToX, float moveToY) {
    pushMatrix();
    translate(moveToX, moveToY);
    rotate(angle);
    ellipse(propX, propY, propW, propH);
    ellipse(propX+propW/2, propY+propH/2, propW, propH);
    ellipse(propX-propW/2, propY+propH/2, propW, propH);
    ellipse(propX+propW/2, propY-propH/2, propW, propH);
    ellipse(propX-propW/2, propY-propH/2, propW, propH);
    popMatrix();
  }
}