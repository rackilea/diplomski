private void afegir(ActionEvent event) throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/model/Afegir.fxml"));
    Parent root = loader.load();
    //load the correct controller
    AfegirController controller = loader.getController();
    Scene scene = new Scene(root);
    Stage ventana2= new Stage();
    ventana2.setMinHeight(380);
    ventana2.getIcons().add(new Image("/estil/Boo.png"));
    ventana2.setMinWidth(770);
    ventana2.setTitle("Afegir dades");
    ventana2.initModality(Modality.APPLICATION_MODAL);
    ventana2.setScene(scene);
    taula.subs = new ObservableList<Subvencio>();
    ventana2.showAndWait();
    //Add the sub to Observable list here and add the observableList to tableview.
    subs.add(controller.getSub());
    tabla.setItems(subs);
}