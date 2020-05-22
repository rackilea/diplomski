BorderPane root = new BorderPane();
Pane paneCenter= new Pane();
Canvas background= new Canvas(1200,1000);
Canvas animation = new Canvas(1200,1000);
Canvas animation2 = new Canvas(1200,1000);
paneCenter.getChildren().addAll(background, animation, animation2);
root.setCenter(paneCenter);

VBox paneRight = new VBox();
paneRight.setPrefSize(200, 1000);
paneRight.setPadding(new Insets(20));
paneRight.setAlignment(Pos.TOP_CENTER);
Button b1 = new Button("Spawn Civilian"); 
paneRight.getChildren().add(b1);
root.setRight(paneRight);

Scene scene = new Scene(root, 1400, 1000);