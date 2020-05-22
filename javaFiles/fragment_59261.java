public static void checkCheck() {
  boolean isInCheck = false;
  for (Move m : player1.getLegalMoves()) {
            if (m.getX() == player2.getKing().getLocX()
            && m.getY() == player2.getKing().getLocY()) {
                isInCheck = true;
                System.out.println("IN CHECK PLAYER 2");
                break;
            }
    }
        player2.setCheck(isInCheck);

    isInCheck = false;
    for (Move m : player2.getLegalMoves()) {
        if (m.getX() == player1.getKing().getLocX()
        && m.getY() == player1.getKing().getLocY()) {
            isInCheck = true;
            System.out.println("IN CHECK PLAYER 1");
            break;
        }
    }
    player1.setCheck(isInCheck);
}