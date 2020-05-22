// You are on a mine
if(minefield[i][j].equals("*")){

    // Now go around your current position
    for(int tempRow = i-1; tempRow <= i+1; tempRow++) {
        for(int tempCol = j-1; tempCol <= j+1; tempCol++) {
            // If a valid square and not a mine
            if(tempRow >= 0 && tempRow < row &&
                tempCol >= 0 && tempCol < colm &&
                !minefield[tempRow][tempCol].equals("*")) 
            {
                // Do your update stuff
                int val = Integer.parseInt(minefield[tempRow][tempCol]);
                val++;
                minefield[tempRow][tempCol] = "" + val;
            }
        }
    }
}