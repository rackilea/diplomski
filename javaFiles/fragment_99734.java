public void drawBoard(Graphics g, Slot[][] board) {
   for(int i=0;i<2;i++) {
       for(int j=0;j<12;j++){
           board[i][j].drawSlot(g);
       }
   }
}