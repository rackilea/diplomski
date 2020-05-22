try {
    CheckConnection();

    FXMLLoader loader = new FXMLLoader();
    loader.setController(new OperatoriController());

    Parent root = loader.load(getClass().getResource("TabLayout.fxml"));
    Scene scene = new Scene(root,600,400);
    scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
    primaryStage.setTitle("Gestione Personale");
    primaryStage.setScene(scene);
    primaryStage.show();
    primaryStage.setMaximized(true);
} catch(Exception e) {
    e.printStackTrace();
}