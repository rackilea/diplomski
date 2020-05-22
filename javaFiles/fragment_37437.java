TextObject to;

void setup(){
  size(400,400);
  to = new TextObject("test", 0, height/2);
}

void draw(){
  background(0);
  if(frameCount % 300 == 0) to.set(0, height/2);
  to.move(1,0);
  to.display();
}

class TextObject
{
  float x, y;
  String text;
  PFont f;

  TextObject(String s, float x, float y){
    this.x = x;
    this.y = y;
    this.text = s;
    f = createFont("Georgia", 32);
  }
  TextObject(String s, float x, float y, PFont f){
    this.x = x;
    this.y = y;
    this.text = s;
    this.f = f;
  }
  void set(float x, float y){
    this.x = x;
    this.y = y;
  }
  void move(float dx, float dy){
    x += dx;
    y += dy;    
  }
  void display(){
    textFont(f);
    text(text, x, y);
  }
}