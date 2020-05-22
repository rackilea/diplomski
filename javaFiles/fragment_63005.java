private void drawBoard(Board board){
    System.out.print('\f');
    System.out.println("  " + board.getPosition(1) + "  |  " + board.getPosition(2) + "  | " + board.getPosition(3) + "   ");
    System.out.println("----------------");
    System.out.println("  " + board.getPosition(4) + "  |  " + board.getPosition(5) + "  | " + board.getPosition(6) + "   ");
    System.out.println("----------------");
    System.out.println("  " + board.getPosition(7) + "  |  " + board.getPosition(8) + "  | " + board.getPosition(9) + "   ");
    System.out.println();
}