FXMLLoader loader = new FXMLLoader(
  getClass().getResource(
    "customerDialog.fxml"
  )
);

Pane pane = (Pane) loader.load();

CustomerDialogController controller = 
    loader.<CustomerDialogController>getController();
controller.initData(customer);