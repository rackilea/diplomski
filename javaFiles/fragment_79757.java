Rectangle rectangle = new Rectangle(0, 0, imgWidth, imgHeight);
    rectangle.setFill(Color.rgb(33, 150, 243, 0.35));
    Pane pane = new Pane();
    VBox vbox = new VBox(); 
    vbox.getChildren().addAll(pane);
    pane.getChildren().addAll(hbox,rectangle);