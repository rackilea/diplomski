public int neighborCount(int row, int col) {

    int count = 0;
    for(int i = row - 1; i <= row + 1; i++) {
        if (i >= 0 && i < society.length) // fixed here
            for(int j = col - 1; j <= col + 1; j++) 
                if (j >= 0 && j < society[i].length) // fixed here
                    if (i != row || j != col) 
                        if (society[i][j] == 'o') 
                            count++;
    }

    return count;
}