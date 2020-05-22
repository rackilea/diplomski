// This program pretends board is a boolean[][] array
boolean horizontalFlag = true; // Assume that it is a 3 in a row
boolean verticalFlag = true; // If it is proven not to be, then change to false
for(int i=0; i<3; i++){
    for(int j=0; j<3; j++){
        if(!(board[i][j])) verticalFlag = false; // These methods draw horizontal and vertical lines
        if(!(board[j][i])) horizontalFlag = false; //i.e.
    }
}
/* What the code does, visualized.
Horizontal check = h vertical check = v both = b none = 0
This is based on each iteration of i.
 i=0   i=1   i=2
b h h|0 v 0|0 0 v
v 0 0|h b h|0 0 v
v 0 0|0 v 0|h h b
*/
if(board[1][1]) { // Diagonals
    if(board[0][0] && board[2][2]) return true; 
    if(board[2][0] && board[0][2]) return true; 
}
if(horizontalFlag||verticalFlag) return true; // If the flags "say" that there are straight lines