PImage snowflakeImg;
Snowflake snowFlake;

int numSnowflakes = 99;
Snowflake[] snowflakes = new Snowflake[numSnowflakes]; 

void setup() {
  imageMode(CENTER);
  //snowflakeImg = loadImage("snowflake.png", "png");
  PGraphics snowflakeG = createGraphics(25,25);
  snowflakeG.beginDraw();
  snowflakeG.rectMode(CENTER);
  snowflakeG.rect(0,0,25,25);
  snowflakeG.endDraw();
  snowflakeImg = snowflakeG;

  for(int i = 0 ; i < numSnowflakes; i++){
    snowflakes[i] = new Snowflake(25, 25);
  }

  size(800,600);
}

void draw(){
  background(0);
  for(int i = 0 ; i < numSnowflakes; i++){
    snowflakes[i].descend();
    snowflakes[i].update();  
  }
}
class Snowflake{
  float imgWidth;
  float imgHeight;
  PVector pos;
  PVector vel;
  final float firstXPos;

  float a = 0.0;
  float angularVel = 0.01;

  float x;
  float amp;
  float period;

  Snowflake(float xWidth, float yHeight){
    imgWidth = xWidth;
    imgHeight = yHeight;
    pos = new PVector(random(width), 0);
    vel = new PVector(0,1);
    firstXPos = this.pos.x;
  }
  void descend(){
    amp = 75;  
    period = 200;

    x = amp * sin((frameCount/period) * TWO_PI);
    // enter local coordinate system #1
    pushMatrix();
    // move to flake position
    translate(firstXPos,this.pos.y);
      // enter local coordinate system #2
      pushMatrix();
        // move to updated (oscillated) x position
        translate(x, this.pos.y);
        // rotated from translated position (imageMode(CENTER) helps rotate around centre)
        rotate(frameCount * 0.1);
        // render the image at it's final transformation
        image(snowflakeImg,0,0, imgWidth, imgHeight);
      popMatrix();
    popMatrix();

    //creating a line for oscillation reference
    //translate(firstXPos, this.pos.y);
    //stroke(255);
    //line(0,0,x,y);

}
  void update(){
    pos.add(vel);
    a += angularVel;
  }

}