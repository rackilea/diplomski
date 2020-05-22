package myapp;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;

public class AddDialogController {
    @FXML private ToggleGroup myToggleGroup;
    @FXML private Dialog<String> dialog;

    public void initialize() {
        dialog.getDialogPane().getButtonTypes().addAll(
                ButtonType.OK, ButtonType.CANCEL
        );

        Node okButton = dialog.getDialogPane().lookupButton(ButtonType.OK);
        okButton.disableProperty().bind(
                Bindings.isNull(
                        myToggleGroup.selectedToggleProperty()
                )
        );

        dialog.setResultConverter(this::convertDialogResult);
    }

    private String convertDialogResult(ButtonType buttonType) {
        if (ButtonType.OK.equals(buttonType)) {
            return getSelectedToggleValue();
        } else {
            return null;
        }
    }

    private String getSelectedToggleValue() {
        RadioButton selectedRadio = (RadioButton) myToggleGroup.getSelectedToggle();

        if (selectedRadio == null) {
            return null;
        }

        return selectedRadio.getText();
    }
}