@FXML
private void reportButtonHandler(ActionEvent event) {
    FXMLLoader fxmlLoader = new 
        FXMLLoader(getClass().getResource("pathtofxml/ReportPage.fxml"));
    Parent root1 = (Parent) fxmlLoader.load();
    Stage stage = new Stage();
    //set what you want on your stage
    stage.initModality(Modality.APPLICATION_MODAL);
    stage.setTitle("Report Page");
    stage.setScene(new Scene(root1));
    stage.setResizable(false);
    stage.show();
}