public class Minimax {
  public static int minimax( Board board, Mark2 currentMark ) {
    int score = 0;
    int[] availableSpaces = board.getAvailableSpaces();

    if ( board.hasWinningSolution() )
      score = (board.getWinningMark() == Mark2.COMPUTER) ? 1 : -1;
    else if ( availableSpaces.length != 0 ) {
      Mark2 nextMark = (currentMark == Mark2.COMPUTER) ? Mark2.PLAYER : Mark2.COMPUTER;

      for ( int availableIndex = 0; availableIndex < availableSpaces.length; availableIndex++ ) {
        board.addMark( availableSpaces[availableIndex], currentMark );
        int nextScore = minimax( board, nextMark );
        board.eraseMark( availableSpaces[availableIndex] );

        if ( currentMark == Mark2.COMPUTER && nextScore > score
            || currentMark == Mark2.PLAYER && nextScore < score
            || availableIndex == 0 )
          score = nextScore;
      }
    }

    return score;
  }
}