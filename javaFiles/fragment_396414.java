AnchorPane anchorPane = new AnchorPane();
anchorPane.setPadding(new Insets(20));

MyToolBar myToolBar = new MyToolBar();
AnchorPane.setTopAnchor(myToolBar, 0.0);
AnchorPane.setLeftAnchor(myToolBar, 0.0);

anchorPane.getChildren().addAll(myToolBar);