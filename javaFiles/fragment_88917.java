ImageView view = new ImageView(image);
// create root with dimension 800x600
Pane root = new Pane();
root.setPrefSize(800, 600);

// attach view to root so it can be displayed
root.getChildren().add(view);

// translate view to 100, 100
// on the screen this means the image will move 100 in X and 100 in Y
view.setTranslateX(100);
view.setTranslateY(100);