public void drawBoard(Graphics g,Slot[][] board) throws IOException{
    for(int i=0;i<2;i++){
        for(int j=0;j<12;j++){
            board[i][j].repaint();
        }
    }
}