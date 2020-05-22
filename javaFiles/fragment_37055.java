void setup() {
  screenSizex = 960;
  screenSizey = 640;
  size(screenSizex, screenSizey);
  gameState = GameState.MENU;
}


void draw(){
  switch(gameState) {
    case MENU:
      //does menu stuff
      break;
    case OPTIONS:
      //does options stuff
      break;
    case GAME:
      //does game stuff
      break;
    default:
      break;
  }
}

void mousePressed() {
  if (/*over some object*/) {
    gameState = GameState.GAME;
  }
  else if (/*over some object*/) {
    gameState = GameState.OPTIONS;
  }
  else if (/*over some object*/) {
    exit();
  }
}