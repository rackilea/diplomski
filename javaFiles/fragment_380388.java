public class Controller {

  private Stage otherStage;

  @FXML
  private void btn_Validate(ActionEvent event) {
    if (otherStage == null) {
      Parent root = ...;

      otherStage = new Stage();

      otherStage.setOnHiding(we -> otherStage = null);

      otherStage.setScene(new Scene(root));
      otherStage.show();

    } else {
      otherStage.toFront();
    }

}