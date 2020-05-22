public void update(GameContainer gc, StateBasedGame sbg, int delta)throws SlickException{
    xpos = Mouse.getX();
    // 600 is the Screen height
    ypos = Math.abs(600-Mouse.getY());

  if((xpos >= 0 && xpos <= 127) && (ypos>= 0 && ypos <= 33)){
   if(Mouse.isButtonDown(0)){
    sbg.enterState(1);
   }
  }

}