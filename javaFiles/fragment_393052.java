if(!bouncy){
  bouncy = true; // next time we are in this game state it will not trigger immediately
  sbg.enterState(2);
}

if(backToGame == true){
  backToGame = false; // same here 
  sbg.enterState(state);
}