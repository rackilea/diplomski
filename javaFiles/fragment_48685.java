static final int NB_ROWS = 4;
static final int NB_COLUMNS = 7;

public static void main(String[] args) {

    boolean[][] initialState = new boolean[NB_ROWS][NB_COLUMNS];
    //everything is initialize to false
    System.out.println(algo(initialState, 0, 0, 0));

}

//path: column by column
public static int algo(boolean[][] state, int currentRow, int currentColumn, int acc) {
    if(currentColumn == NB_COLUMNS) { //end of the array reached
        return acc + 1;
    }
    if(currentRow == NB_ROWS) { //end of the column reached
        if(checkColumn(state, currentColumn)) { //the current column meets requirements
            return algo(state, 0, currentColumn+1, acc);
        } else {
            return acc;
        }
    }
    state[currentRow][currentColumn] = true; //try with true at the given coordinates
    if(checkRow(state, currentRow)) { //current row meets the requirements
        acc += algo(state, currentRow+1, currentColumn, 0); //start with a fresh counter
    }
    state[currentRow][currentColumn] = false; //try with false at the given coordinates
    // no need to check row with a false value
    return algo(state, currentRow+1, currentColumn, acc);
}

public static boolean checkColumn(boolean[][] state, int currentColumn) {
    int count = 0;
    for(int i=0; i<NB_ROWS; i++) {
        if(state[i][currentColumn])
            count++;
    }
    return count == 2;
}

public static boolean checkRow(boolean[][] state, int currentRow) {
    int count = 0;
    for(int i=0; i<NB_COLUMNS; i++) {
        if(state[currentRow][i])
            count++;
    }
    return count <= 5;
}