if (Gdx.input.isTouched())
{
  //Finger touching the screen
  // You can actually start calling onClick here, if those variables and logic you are using there are correct.
  if (Gdx.input.getX() >= screenSize / 2)
  {
    //Right touched
  }
  else if (Gdx.input.getX() < screenSize / 2)
  {
    //Left touched
  }
}