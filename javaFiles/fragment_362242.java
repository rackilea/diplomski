boolean isFinished = true;
     if (drawArray[ROW][COL+1] == ' ' && drawArray[ROW][COL+2] == 'E') {
         move(ROW,COL,ROW,COL+2);
     } else if (drawArray[ROW][COL-1] == ' ' && drawArray[ROW][COL-2] == 'E') {
         move(ROW,COL,ROW,COL-2);
     } else if (drawArray[ROW+1][COL] == ' ' && drawArray[ROW+2][COL] == 'E') {
         move(ROW,COL,ROW+2,COL);
     } else if (drawArray[ROW-1][COL] == ' ' && drawArray[ROW-2][COL] == 'E') {
         move(ROW,COL,ROW-2,COL);
     } else {
         isFinished = false;
     }

     int foundOpen = 0;
     if (!isFinished) {