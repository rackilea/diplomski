public class MainController {    
    ...

   // you can leave out the event parameter here, if you don't need it;
   // otherwise be sure to use a parameter of type ActionEvent    
    @FXML
    private void modify() throws IOException {
        myData data = valueTable.getSelectionModel().getSelectedItem();
        if (data != null) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("modify.fxml"));
            Parent root = loader.load();
            ModifyController mpc = loader.getController();
            mpc.setData(data);
            Stage modifyStage = new Stage();
            Scene modfifyPartScene = new Scene(root);
            modifyStage.setScene(modfifyPartScene);
            modifyStage.showAndWait();
            if (mpc.isEdited()) {
                valueTable.refresh(); // or update the table by other means
            }
        }
    }
}