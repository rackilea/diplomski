TextField sudokuCell = sudokuCells[row][col];
sudokuCell.focusedProperty().addListener((obs, wasFocused, isNowFocused) -> {
    if (isNowFocused) {
        sudokuCell.setStyle("-fx-background-color: green;");
    } else {
        sudokuCell.setStyle("");
    }
});