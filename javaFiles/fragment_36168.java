public class FXMLDocumentController {

  @FXML
  private ProgressBar bar;

  @FXML
  private void initialize() {
    bar.setProgress(ProgressBar.INDETERMINATE_PROGRESS);
  }

}