private boolean isEmpty() {
    boolean empty = true;
    for (int i=1;i<myAsciiGrid.length-1;i++) {
        for (int j=1;j<myAsciiGrid[0].length-1;j++) {
            if (!myAsciiGrid[i][j].equals(" ")) {
                return false;
            }
        }
    }
    return empty;
}