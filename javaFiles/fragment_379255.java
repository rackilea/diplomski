Zoog[]zoog = new Zoog[1];
float count=0;
int xpos =0;
int ypos =0;
String message="haha";
int ntextsize = 20;
int nopacity =200;
int thistime = 0;
int thiscount = 0;
//Zoog zoog;

void setup() {
  size(400, 400);
  xpos = int(random(width/2-200, width/2+40));
  ypos = int(random(height/2, height/2-40));
  zoog[0] = new Zoog(xpos, ypos, message, nopacity);
}

void draw() {
  background(255);

  for (int i=0; i<zoog.length; i++) {
    zoog[i].jiggle();
    zoog[i].display();  }
}




void mousePressed() {
  count = count + 1;
  // int thiscount = 0;
  if (count%3 ==0) {
    xpos=int(random(30, width-30));
    ypos=int(random(10, height-10));
  }
  else {
    ypos = ypos+50;
    //   thiscount = thiscount +1;
    //   thistime = millis();
    //  }
  }


  nopacity = int(random(100, 255));
  text(message, xpos, ypos);
  Zoog b = new Zoog(mouseX, mouseY, message, nopacity);
  zoog = (Zoog[]) append(zoog, b);

  zoog[zoog.length -2].disappear = true;
}





class Zoog {
  int x;
  int y;
  String thatmessage;
  boolean disappear;

  int opaci =0;

  Zoog(int xpo, int ypo, String thismessage, int opa) {
    x = xpo;
    y = ypo;
    thatmessage = thismessage;

    opaci = opa;
  }

  void jiggle() {

    x = x+int(random(-2, 2));
    y = y+int(random(-2, 2));
  }

  void display() {
    if(disappear)
    disappear();
    fill(0, opaci);
    text(thatmessage, x, y);
  }

  void disappear() {

    opaci-=0.5;

  }
}