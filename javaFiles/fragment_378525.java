enum State { TURN_P1, TURN_P2, MAIN, PAUSE, ... }
public State gameState
...

public void mouseClicked(MouseEvent e)
{
  if (gameState == TURN_P1)
  {
    ...

    if (move_is_legal and so on)
      gameState = TURN_P2;
  }
  else if (gameState == TURN_P2)
  {
    ...

    if (move_is_legal and so on)
      gameState = TURN_P1;
  }
}