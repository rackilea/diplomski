WebView frameView = new WebView();
frameView.getEngine().load(frameLocation.toString());

Stage stage = new Stage();
stage.setTitle("Frame content");
stage.setScene(new Scene(new BorderPane(frameView)));
stage.show();