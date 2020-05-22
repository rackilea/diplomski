static void fillBoard(ArrayList<Case> inArray) {
    clearBoard();
    for (Case aCase in inArray) {
        insertCaseToBoard(aCase);
    }
}