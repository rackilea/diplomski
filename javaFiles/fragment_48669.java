// Stack Gridpane into root pane to organize circles on rails
GridPane grid = new GridPane();

// loop to instantiate all circles in a 5x10 grid, add to gridpane
for (int row = 0; row < 5; row++) {
    for (int count = 10; count > 0; count--) {
        StackPane sp = new StackPane();
        grid.add(sp, count, row);

        Circle circle = new Circle();
        circle.setRadius(20);

        // generate Labels and position on circle
        Text label = new Text(Integer.toString(count));
        label.getStyleClass().add("text");
        label.setFill(Color.RED); // Added so it's visible

        // Don't need these
        //label.setX(circle.getCenterX());
        //label.setY(circle.getCenterY());

        //bind label to circle movement
        //label.translateXProperty().bind(circle.translateXProperty());
        //root.getChildren().add(label);

        // Add circle and label to StackPane so it'll handle layout for you
        sp.getChildren().addAll(circle, label);
    }
}
root.getChildren().add(grid);