else if(drawArray[ROW][COL-1] == ' ' && drawArray[ROW][COL-2] != '*'){
           drawArray[ROW][COL-2] = '*';
           prevCol = COL;
           prevRow = ROW;
           //Wrong: ROW-= 2;
           COL -= 2; // Good?
           foundOpen = 1;
        }