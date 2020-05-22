public void newDate() {

    Stage newDate = new Stage();

    Parent root;
    try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("newDate.fxml"));
        root = loader.load();
        NewDateController controller = loader.getController();
        controller.setData(listItems);

    } catch (IOException e) {
        e.printStackTrace();
        return;
    }
    Scene sceneNewDate = new Scene(root);

    newDate.setTitle("Neuer Termin");
    newDate.setScene(sceneNewDate);
    newDate.show();


}