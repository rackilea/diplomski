// Cardinal directions
int[] dx = { 1, 0, -1,  0 };
int[] dy = { 0, 1,  0, -1 };

// Loop through each space
for (int j=0; j<10; j++) {
    for (int i=0; i<10; i++) {

        // Check if you have a movable piece there
        if(gameBoard[i][j].hasMovablePiece() && !gameBoard[i][j].hasEnemyPiece()) {

            // Check neighbors
            for (int k=0; k<4; k++) {
                int ni = i+dx[k];
                int nj = j+dy[k];

                // Bounds check
                if(ni >= 0 && nj >=0 && ni < 10 && nj < 10) {

                    // Check if space is an enemy or empty and not blocked
                    // If so we still have a move
                    if((!gameBoard[ni][nj].hasPiece() || gameBoard[ni][nj].hasEnemyPiece()) && !gameBoard[ni][nj].isBlocked()){
                        return false;
                    }
                }

            }
        }
    }
}

// We made it without finding a movable piece
return true;