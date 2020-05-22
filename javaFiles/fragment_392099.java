public class TitForTat implements Strategy {
  private boolean lastMove;

  public void opponentMove(boolean isDefecting) {
     lastMove = isDefecting;
  }

  public boolean isDefecting() {
    return lastMove;
  }
}