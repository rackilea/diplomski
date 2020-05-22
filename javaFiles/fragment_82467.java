public boolean checkDiagonalForWin(String b, int row, int col){

    for (int inRow = 0; row  < size && col < size; row++, col++) {
        //Check all the rows for a winner
        if (globalGrid[row][col].equals(b)){
            inRow++;
            if (inRow >= neededToWin){
                return true;
            }
        }else{
            inRow = 0;
        }
    }
    return false;
}


public boolean checkOtherDiagonalForWin(String b, int row, int col){        
    for (int inRow = 0; row  < size && col >= 0; row++, col--) {
        //Check all the rows for a winner
        if (globalGrid[row][col].equals(b)){
            inRow++;
            if (inRow >= neededToWin){
                return true;
            }
        }else{
            inRow = 0;
        }
    }
    return false;
}