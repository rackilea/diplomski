package sceneswitcher;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class AController {

    private ViewModel viewModel ;

    @FXML
    private TextField textField ;

    public void setViewModel(ViewModel viewModel) {
        this.viewModel = viewModel ;
    }

    // button handler:
    @FXML
    private void goToB(ActionEvent event) {
        viewModel.setCurrentView(ViewModel.View.B);
    }

    public String getText() {
        return textField.getText();
    }
}