import java.io.IOException;
import org.controlsfx.glyphfont.Glyph;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.Pane;

public class ListCellController2 extends ListCell<Student> {

    @FXML
    private Glyph attendenceSymbolGlyph;
    @FXML
    private Label studentDetailsLabel;
    @FXML
    private Pane entryPane;

    public ListCellController2() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setController(this);
            loader.setLocation(getClass().getResource("ListCell2.fxml"));
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException("Creating UI component failed", e);
        }
    }

    @Override
    protected void updateItem(Student student, boolean empty) {
        super.updateItem(student, empty);

        if (empty || student == null) {
            setText(null);
            setGraphic(null);
        } else {
            studentDetailsLabel.setText(student.toString());
            setGraphic(entryPane);
        }
    }
}