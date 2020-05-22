private void checkEmptyFields(Star star) {
    boolean visited[9][6] = new visited[9][6];
    //get the star's coordinates somehow, you may have to change this
    int i = star.row;
    int j = star.col;
    visited[i][j] = true;

    int freeFieldCount = 0;
    Queue<Field> q = new LinkedList<Field>();
    q.add(fields[i][j]);

    while(!q.isEmpty()) {
         Field current = q.poll();
         //get the coordinates from the field, you may have to change this
         i = current.row;
         j = current.col;
         int rowUpperLimit = i + 1;
         int rowLowerLimit = i - 1;
         int colUpperLimit = j + 1;
         int colLowerLimit = j - 1;
         if(rowUpperLimit >= 9) {
              rowUpperLimit = 8;
         }
         if(rowLowerLimit < 0) {
              rowLowerLimit = 0;
         }
         if(colUpperLimit >= 6) {
              colUpperLimit = 5;
         }
         if(colLowerLimit < 0) {
              colUpperLimit = 0;
         }
         //check immediate neighbors
         for(int m = rowLowerLimit; m <= rowUpperLimit; m++) {
             for(int n = colLowerLimit; n <= colUpperLimit; n++) {
                 if((m != i && n != j) && !visited[m][n] && !fields[m][n].isOccupied()) {
                     freeFieldCount++;
                     visited[m][n] = true;
                     q.add(fields[m][n]);
                 }
             }
         }
    }

    return freeFieldCount;
}