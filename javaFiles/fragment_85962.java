GridPane grid = new GridPane();

Label first = new Label("first");
Label second = new Label("second");

grid.add(first,  1,  1);
grid.add(second,  2,  2);
second.setOnMouseClicked(e -> {
    grid.getChildren().remove(second);
    grid.add(new Label("last"), 2, 2);
});
box.getChildren().addAll(grid);