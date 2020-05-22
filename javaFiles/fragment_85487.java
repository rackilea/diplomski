public static boolean full(Color[][] board) {
    for(int i = 0; i < board.length; i++){
        for(int j=0; j<board.length;j++) {
            if (board[i][j] == Color.WHITE){
                return false;
            } else {
                return true;
            }
        }
    }
}