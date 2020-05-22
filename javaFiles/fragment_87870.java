Stage dialogStage = new Stage();
FXMLLoader loader = new FXMLLoader(getClass().getResource("Dialog.fxml"));
AnchorPane root = (AnchorPane)loader.load();
DialogController controller = (DialogController) loader.getController();
Scene scene = new Scene(root);
dialogStage.setScene(scene);
dialogStage.showAndWait();