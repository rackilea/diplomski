Accordion accordion = new Accordion();
TitledPane titledPane = new TitledPane();
titledPane.setText("Title");
GridPane gridPane = new GridPane();
gridPane.setStyle("-fx-background-color:red");

gridPane.add(new TextArea("Hello"), 0, 0);
gridPane.add(new TextArea("World"), 0, 1);

titledPane.setContent(gridPane);
accordion.getPanes().add(titledPane);