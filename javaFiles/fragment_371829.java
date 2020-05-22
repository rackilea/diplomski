while(!q.isEmpty()) {
         Field current = q.poll();
         //get the coordinates from the field, you may have to change this
         i = current.row;
         j = current.col;
         int rowUpperLimit = i + 1;
         int rowLowerLimit = i - 1;
         int colUpperLimit = j + 1;
         int colLowerLimit = j - 1;
         if(colLowerLimit > -1) {
             //check neighbor to the left
             if(!visited[i][colLowerLimit] && !fields[i][colLowerLimit].isOccupied()) {
                 freeFieldCount++;
                 visited[i][colLowerLimit] = true;
                 q.add(fields[i][colLowerLimit]);
             }
         }
         if(colUpperLimit < 6) {
             //check neighbor to the right
             if(!visited[i][colUpperLimit] && !fields[i][colUpperLimit].isOccupied()) {
                 freeFieldCount++;
                 visited[i][colUpperLimit] = true;
                 q.add(fields[i][colUpperLimit]);
             }
         }
         if(rowLowerLimit > -1) {
             //check neighbor below
             if(!visited[rowLowerLimit][j] && !fields[rowLowerLimit][j].isOccupied()) {
                 freeFieldCount++;
                 visited[rowLowerLimit][j] = true;
                 q.add(fields[rowLowerLimit][j]);
             }
         }
         if(rowUpperLimit < 9) {
             //check neighbor above
             if(!visited[rowUpperLimit][j] && !fields[rowUpperLimit][j].isOccupied()) {
                 freeFieldCount++;
                 visited[rowUpperLimit][j] = true;
                 q.add(fields[rowUpperLimit][j]);
             }
         }
    }
}