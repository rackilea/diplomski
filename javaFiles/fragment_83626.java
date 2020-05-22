SnowFlake snowFlake;

void setup(){
  size(500, 500);
  snowFlake = new SnowFlake();
}

void draw(){
  background(0);
  snowFlake.draw();
}