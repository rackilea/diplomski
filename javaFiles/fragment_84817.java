int row = rowStart;
    int col = colStart;
    for( MyObject temp : myObjs ) {
        myTable.setValueAt(temp,row,col);
        col+=2;
        if ( col >= colCount ) {
            col = colStart;
            row+=2;
        }
    }