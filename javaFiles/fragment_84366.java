class game {
String[][] board= new String[][]{{" ", " ", " "}, {" ", " ", " "}, {" ", " ", " "}};
String player="x";



public void make_move(int square) {
    board[square / 3][square % 3] = player;
    player = (player.equals("x")) ? "O" : "x";

}}