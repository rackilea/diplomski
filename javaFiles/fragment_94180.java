private int minimax(Gameboard gameBoard, int depth, char color) {
    Gameboard gb = new Gameboard(gameBoard);
    int bestChoice = 0;
    int bestValue = 0;

    //If we've won, return highest possible value. If we've lost, return lowest.
    if (gb.CheckForWinner(gb.lastSpacePlayed)) {
        if(gb.winner == color){
            return Integer.MAX_VALUE
        }else{
            return Integer.MIN_VALUE
        }

    }
    //if we hit maximum depth, resort to our heuristic method.
    else if (depth == maxDepth) {
        return threatLevel(gb, color);
    } else {
        // Generate moves for each col and find the best score from each of
        // the generated moves. Keep track of the worst one.
        int worstBestResponse = Integer.MAX_INT
        boolean tie = true;
        for (int c = 0; c < 7; c++) {
            Gameboard game = new Gameboard(gb);
            int selectedPlace = game.PlacePiece(c, color);

            // Recursive call the generated game grid and compare the
            // current value to move value
            // If move is higher, make it the new current value.

            if (selectedPlace != -1) {
                tie = false;
                char tempColor;
                // change the user for the child node after a piece is played
                if (color == 'Y') {
                    tempColor = 'R';
                } else {
                    tempColor = 'Y';
                }
                // call the function so we can explore to maximum depth
                if (depth < maxDepth) {
                    int v = minimax(new Gameboard(game), depth + 1, tempColor);
                    if (v < worstBestResponse) {
                        worstBestResponse = v;
                    }
                }
            }
        }

        if(tie) {
            //if game is a tie, we return 0, to show no favour.
            return 0;
        } else {
            //After determining the value of the opponents best response, we return the negative value of it. That is, what's bad for them is good for us and visa versa.
            return -worstBestResponse;
        }
    }
}