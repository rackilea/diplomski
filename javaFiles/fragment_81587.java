long leftOn = 0;
long rightOn = 0;

void draw() {

  // clear window buffer (white color)
  background(255);

  if (mousePressed == true && mouseButton == LEFT) {

    // remember timestamp when left button was pressed in variable leftOn
    leftOn = millis();
    rightOn = 0;

  } else if (mousePressed == true && mouseButton == RIGHT) {

    // remember timestamp when right button was pressed
    rightOn = millis();
    leftOn = 0;

  }

  // now is current timestamp
  long now = millis();

  /*
   * if now - last left click distance is lower than 1000 ms - draw left rect
   * else if now - right left click distance is lower than 1000 ms - draw right rect
   */ 
  if (now - leftOn <= 1000*1) {
    fill(0,255,0);
    rect(0,0,width/2,height);
  } else if (now - rightOn <= 1000*1) {
    fill(255,255,0);
    rect(width/2, 0, width/2, height);
  } 

  // else - nothing is drawn in this frame, so window will be empty in this frame 

}