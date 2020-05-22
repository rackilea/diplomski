TabPane tabPane = new TabPane();
Tab tab = new Tab("Testing");
tab.setContent(new VBox(new Label("Here is the testing place"), new Circle(15, 12, 10)));

Tab tab2 = new Tab("Testing2");
HBox hboxContentTab2 = new HBox();
hboxContentTab2.getChildren().add(new Ellipse(10, 10, 10, 13));
hboxContentTab2.getChildren().add(new Label("Here is the BIS testing place"));
tab2.setContent(hboxContentTab2); // add a Node created before, ot can be whatever you wan, borderpane, gridpane, hbox, vbox, label ...

tabPane.getTabs().addAll(tab, tab2);