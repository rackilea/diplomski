int i = begx + xdiff;
    int j = begy + ydiff;
    while (true) {
        if(board[i][j].getType() != ' ') {
            if(board[i][j].getType() == '#') {
                return false;
            }
            if(board[i][j].getTeam().equals(team)) {
                return false;
            }
            if(board[i][j].getType() == 'Q' || board[i][j].getType() == 'R') {
                return true;
            }
        }
        i += xdiff; 
        j += ydiff;
    }