boolean[] keys = new int[255];

void keyPressed() {
  keys[keyCode] = true;
}

void keyReleased() {
  keys[keyCode] = false;
}

void draw() {
  updatePlayers();
  drawStuff();
}

void updatePlayers() {
  if(keys[LEFT]) { p1.move(-1,0); }
  if(keys[RIGHT]) { p1.move(1,0); }
  if(keys[UP]) { p1.move(0,-1); }
  if(keys[DOWN]) { p1.move(0,1); }

  if(keys['a']) { p2.move(-1,0); }
  if(keys['d']) { p2.move(1,0); }
  if(keys['w']) { p2.move(0,-1); }
  if(keys['s']) { p2.move(0,1); }
}