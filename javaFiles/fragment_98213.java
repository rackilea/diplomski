float x = 400, y=100;

int a=20,b=10;

  void setup() 
  { 
  size(800, 200); 
  }
  void draw() 
  {
   background(200); // to erase the screen everyframe 
   rect(x-a/2, y-b/2, a, b);
  }
  void keyPressed() 
  {
  if (keyCode == RIGHT) {
  x+=5;
  } 
  else if (keyCode == LEFT) {
  x-=5;
  } 
  else if (keyCode == UP){
    y-=5;
  } 
  else if (keyCode == DOWN){
    y+=5;
  }
  else if(key==' '){ //you need to put double equal for checking instead of just one
   a*=2; // same as a=a*2;
   b*=2; // same as b=b*2;
    }
  }