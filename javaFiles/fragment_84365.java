class game {
String[][] board;
String player;


game() {
    board = new String[][]{{" ", " ", " "}, {" ", " ", " "}, {" ", " ", " "}};
    player = "x";
}

public void make_move(int square) {
    board[square / 3][square % 3] = player;
    player = (player.equals("x")) ? "O" : "x";

} }