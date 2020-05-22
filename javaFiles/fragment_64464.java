Here are a few tweaks to your code:
int i, j;
int hw;
boolean smooth;
void setup() {
  size(1440, 900);
  background(0);

  strokeWeight(10);

  hw = width/2;
  i = width/2 - (width/2);//isn't this 0 ?
  j = width;
}

void draw() {
  fill(0,mousePressed ? 255 : 10); // semi-transparent black
  noStroke();
  rect(0, 0, width, height); //legger seg lag på lag
  if (i < width-200) {
    i+=4;
    j-=4;
  }
  else {
    i = 0;
    j = width;
  }

  stroke(255);
  beginShape(LINES);
  for(int k = 0; k < 200; k+= 40){
    vertex(hw, height);vertex(i+k, 30);
    vertex(hw, height);vertex(j-k, 30);
  }
  endShape();
  frame.setTitle((int)frameRate+" fps, smooth: " + smooth); 
}

void keyReleased(){
  smooth = !smooth;
  if(smooth) smooth();
  else       noSmooth();
}