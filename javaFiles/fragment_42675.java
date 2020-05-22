public GrapherScene() {
    try {

        Stage grapherStage = new Stage();
        FXMLLoader loader = new FXMLoader(getClass().getResource("grapher.fxml"));
        grapherStage.setScene(new Scene(loader.load());
        grapherStage.setTitle("Grapher");
        grapherStage.show();

        // Must be called AFTER loader.load()
        // Method has generic return type so explicit casting is not necessary in this case
        GrapherController grapher = loader.getController();
        grapher.test();

    } catch (Exception ex) {
        ex.printStackTrace();
    }
}