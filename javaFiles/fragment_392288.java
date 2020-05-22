for (final Button button : dummyButtons()) {
    GridPane.setRowIndex(button, i / (int) nColumns);
    GridPane.setColumnIndex(button, i % (int) nColumns);

    button.setMinSize(MIN_TILE_SIZE, MIN_TILE_SIZE);
    button.setMaxSize(MAX_TILE_SIZE, MAX_TILE_SIZE);

    gridPane.getChildren().add(button);

    i++;
}

for (int j = 0; j < nColumns; j++) {
    ColumnConstraints cc = new ColumnConstraints();
    cc.setHgrow(Priority.ALWAYS);
    gridPane.getColumnConstraints().add(cc);
}

for (int j = 0; j < nRows; j++) {
    RowConstraints rc = new RowConstraints();
    rc.setVgrow(Priority.ALWAYS);
    gridPane.getRowConstraints().add(rc);
}