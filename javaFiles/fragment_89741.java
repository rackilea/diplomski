GridPane gridPaneMain = new GridPane();
Image image = new Image(
            BoardGameMain.class.getResourceAsStream("viewcontrollers/blank.png"));
for (int x = 0; x <= 6; ++x) {
    Button button = ...;
    gridPaneMain.add(button, x, 0, 1, 1);
    ImageView imv = new ImageView();
    imv.setImage(image);
    final HBox pictureRegion = new HBox();
    pictureRegion.getChildren().add(imv);
    gridPaneMain.add(pictureRegion, x, 1);
}
Scene scene = new Scene(gridPaneMain, 800, 800);