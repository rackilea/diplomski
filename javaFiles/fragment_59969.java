package sample;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main extends Application {
private boolean editable = false;

public static  IndexedCell getCell(final Control control, final int index) {
    return getVirtualFlow(control).getCell(index);
}

public static VirtualFlow<?> getVirtualFlow(Control control) {
    Group group = new Group();
    Scene scene = new Scene(group);
    Stage stage = new Stage();

    if(control.getScene() == null) {
        group.getChildren().setAll(control);
        stage.setScene(scene);
        stage.show();
    }

    VirtualFlow<?>flow = (VirtualFlow<?>) control.lookup("#virtual-flow");
    return flow;
}

public void setEditable(ListView contactsList){
        //this needs to be done since we need to run our code after the text field was rendered
        //so we need to invoke our code after this happens, if not it will throw a null pointer...
        Platform.runLater(() -> {
            //this is one of the most important guys because javafx api says that
            //TextFieldListCell.forListView() allows editing of the cell content when the cell is double-clicked,
            // or when {@link ListView#edit(int)} is called.
            int rowIndex = contactsList.getSelectionModel().getSelectedIndex();
            contactsList.edit(rowIndex);
            ListCell rootCell = (ListCell) getCell(contactsList, rowIndex);
            TextField textField = (TextField) rootCell.getGraphic();
            textField.setEditable(editable);
        });
}

@Override
public void start(Stage primaryStage) throws Exception{
    List<String> contacts = new ArrayList<>(Arrays.asList("968787522","3424234234","2343234324"));
    ListView<String> contactsList = new ListView();
    contactsList.setItems(FXCollections.observableArrayList(contacts));
    contactsList.setEditable(true);

    //this gives me the ability to edit the row as text field but I want this text field to not be editable
    contactsList.setCellFactory(TextFieldListCell.forListView());
    contactsList.setOnEditStart(e -> {
        setEditable(contactsList);
    });

    StackPane pane = new StackPane();
    Button editBtn = new Button("Toggle edit");
    editBtn.setOnAction(event -> {
        editable = !editable;
        editBtn.setText("Editing = " + editable);
        //to cancel any editing that might be occuring
        contactsList.getSelectionModel().clearSelection();
    });
    pane.getChildren().addAll(contactsList,editBtn);
    primaryStage.setScene(new Scene(pane, 300, 275));
    primaryStage.show();
}

public static void main(String[] args) {
    launch(args);
}
}