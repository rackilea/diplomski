Button btn = new Button();
btn.setPrefSize(50, 50);
Image imageOk = new Image(getClass().getResourceAsStream("yes.png"));
ImageView img = new ImageView(imageOk);
img.setPreserveRatio(true);
img.fitWidthProperty().bind(btn.widthProperty());
img.fitHeightProperty().bind(btn.heightProperty());
btn.setGraphic(img);