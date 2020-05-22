package sceneswitcher;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class BController {
    private ViewModel viewModel ;

    @FXML
    private TextArea textArea ;

    public void setViewModel(ViewModel viewModel) {
        this.viewModel = viewModel ;
    }

    // button handler:
    @FXML
    private void goToA(ActionEvent event) {
        viewModel.setCurrentView(ViewModel.View.A);
    }

    public String getText() {
        return textArea.getText();
    }
}