package com.company;

import javafx.application.Application;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        ObservableList<Integer> values = FXCollections.observableArrayList();
        values.addAll(1, 2, 3);


        TableColumn<Integer, Integer> tableColumn = new TableColumn<>("Column1");
        tableColumn.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));


        tableColumn.setCellFactory(param -> {
            return new TableCell<Integer, Integer>() {
                @Override
                protected void updateItem(Integer item, boolean empty) {
                    super.updateItem(item, empty);

                    if (item == null) {
                        setText("");
                    } else {
                        setText(item.toString());
                    }
                }
            };
        });


        TableView<Integer> tableView = new TableView<>();
        tableView.setFixedCellSize(Region.USE_COMPUTED_SIZE);
        tableView.getColumns().add(tableColumn);
        tableView.setItems(values);

        tableView.setRowFactory(param -> {
            return new TableRow() {
                @Override
                public void updateIndex(int i) {
                    super.updateIndex(i);

                    setMinHeight(50 * i);
                }
            };
        });

        Scene scene = new Scene(tableView, 320, 480);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}