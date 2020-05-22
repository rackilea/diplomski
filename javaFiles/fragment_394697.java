for (int i = 0; i < 30; i++) {
    gridPane.getColumnConstraints().add(columnConstraints);
}
for(int i = 0; i < 50; i++){
    gridPane.getRowConstraints().add(rowConstraints);
    for(int j = 0; j < 30; j++) {
        Button btn = new Button(Integer.toString(j + 1));
        btn.setPrefSize(40, 40);
        gridPane.add(btn, j, i);
    }
}