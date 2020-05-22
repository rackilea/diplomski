for (int row = 0; row < rowNum; row++) {
    for (int col = 0; col < colNum; col++) {
        int n = rand.nextInt(4);
        Rectangle rec = new Rectangle();
        rec.setWidth(2);
        rec.setHeight(2);
        rec.setFill(colors[n]);
        GridPane.setRowIndex(rec, row);
        GridPane.setColumnIndex(rec, col);
        grid.getChildren().addAll(rec);
    }
}