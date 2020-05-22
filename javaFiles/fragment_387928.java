SudokuImplementation sudokuImplementation =
        new YourSuperSudoku(); // <- your implementation

    SudokuView sudokuView = new SudokuView();
    sudokuView.setSudokuImplementation(sudokuImplementation);
    sudokuView.setVisible(true);