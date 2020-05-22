public GrapherScene() {
    try {
        Stage grapherStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("grapher.fxml"));
        Scene scene = new Scene(root, 600, 400);
    //scene.getStylesheets().add(getClass().getResource("app.css").toExternalForm());
        grapherStage.setScene(scene);
        grapherStage.setTitle("Grapher");
        grapherStage.show();
    } catch (Exception ex) {
        ex.printStackTrace();
    }
    GrapherController grapher = new GrapherController();
    grapher.test();
}