int highestpointer = -1; // Setting to -1 because if the pointer is -1 at the end of the loop, then it would be clear that there was no touch 
for(int pointer = 0; pointer < 20; pointer++) {
     if(Gdx.input.isTouched(pointer)) { // First check if there is a touch in the first place
          int x = Gdx.input.getX(pointer); // Get x position of touch in screen coordinates (far left of screen will be 0)
          if(x < arrowMoveWhite.getWidth() + 40 || x >= arrowMoveX - 40) {
               highestpinter = pointer; 
          } // Note that if the touch is in neither button, the highestpointer will remain what ever it was previously
     }
} // At the end of the loop, the highest pointer int would be the most recent touch, or -1

// And to handle actual movement you need to pass the highest pointer into Gdx.input.getX()
if(!isPlayerHit) { // Minor improvement: only check this once
     if(Gdx.input.isKeyPressed(Keys.RIGHT) || (highestpointer > -1 && Gdx.input.getX(highestpointer) >= arrowMoveX - 40)) {
        x+=SPEED*Gdx.graphics.getDeltaTime();
     } else if(Gdx.input.isKeyPressed(Keys.LEFT) || (highestpointer > -1 && Gdx.input.getX(highestpointer) < arrowMoveWhite.getWidth() + 40)) {
          x-=SPEED*Gdx.graphics.getDeltaTime();
     }
}