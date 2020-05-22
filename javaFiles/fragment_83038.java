void clear() {
    for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
            if (digging_array[i][j] == 1) {
                sudoku[i][j].setText(Integer.toString(final_Array[i][j]));
            } else {
                sudoku[i][j].setText("");
            }
        }
    }
}

Optional<ButtonType> result = right.showAndWait();
if (result.isPresent() && result.get() == quit) {
    stage.setScene(main_frame);
} else if(result.isPresent() && result.get() == restart) {
    clear()
}

Optional<ButtonType> result = wrong.showAndWait();
if (result.isPresent() && result.get() == quit) {
    stage.setScene(main_frame);
} else if(result.isPresent() && result.get() == retry) {
    clear()
}