public void actionPerformed(ActionEvent e) {
     // when lefttop corner tile is clicked
     if("Tile: (0,0)".equals(e.getActionCommand())){
         if(tileDone[0][0] == false){ // checking if its still empty
             if(currentPlayer.equals("X")){ // checking if current player is "X"

                // here...
                tile[0][0].setIcon(new ImageIcon("/home/kaustubh/Desktop /java/TicTacToe/X.png"));
                //panel.add(tile[0][0]);  // remove this

                 panel.repaint();
                 this.repaint();
                 System.err.println();
             }