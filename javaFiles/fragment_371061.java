public class AController {

    private ViewModel viewModel ;

    public void setViewModel(ViewModel viewModel) {
        this.viewModel = viewModel ;
    }

    // button handler:
    @FXML
    private void goToB(ActionEvent event) {
        viewModel.setCurrentView(ViewModel.View.B);
    }
}