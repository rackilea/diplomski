private static int[] buildTables(int noOfTables, int noOfPlayers) {
    int[] tables = new int[noOfTables];
    for (int i = 0, playersLeft = noOfPlayers; i < noOfTables; playersLeft -= tables[i++]) {
        int tablesLeft = noOfTables - i;
        tables[i] = (playersLeft + tablesLeft - 1) / tablesLeft; // round up
    }
    return tables;
}