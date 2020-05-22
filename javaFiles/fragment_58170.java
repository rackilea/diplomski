for (int i = 0; i < kandidaten.length; i++) {
    SudokuBoard newBoard = board.set(freiesNaechstesFeld, kandidaten[i]);
    SudokuBoard solution = findSolution(newBoard);
    if (solution != null {
        return solution;
    }
}