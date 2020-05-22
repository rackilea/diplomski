void setup(){
  size(500, 500);
}

void draw(){
  background(0);

  //draw white
  stroke(255);

  //the start point- try changing this to mouseX and mouseY
  float centerX = width/2;
  float centerY = height/2;

  //the distance from the start point
  float radius = 100;

  //how far apart the points are
  float angleIncrement = 30;

  //loop to go around the circle. Try changing it to 180 to see what happens.
  for(float angleInDegrees = 0; angleInDegrees <= 360; angleInDegrees+=angleIncrement){

    //the first "end point" is the start point of the line
    float startX = centerX + cos(radians(angleInDegrees))*radius;
    float startY = centerY + sin(radians(angleInDegrees))*radius;

    //the second "end point" is the end point of the line
    //notice that we're adding the angleIncrement to the angle to get the next point
    float endX = centerX + cos(radians(angleInDegrees+angleIncrement))*radius;
    float endY = centerY + sin(radians(angleInDegrees+angleIncrement))*radius;

    //draw the line
    line(startX, startY, endX, endY);

  }
}