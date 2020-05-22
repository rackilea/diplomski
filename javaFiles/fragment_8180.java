package application;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;

public class Controller {

    @FXML
    public AnchorPane rootPane;

    @FXML
    public TreeTableView<String> ttv;

    @FXML
    public TreeTableColumn<String, String> ttc;

    @FXML
    public void initialize() {      
        Image img = new Image("http://i.imgur.com/TEgfhOw.png");
        TreeItem<String> root = new TreeItem<>("Root item");
        TreeItem<String> ti;
        for (int a = 0; a < 50000; a++) {
            ti = new TreeItem<>(Integer.toString(a));
//            ti.setGraphic(new ImageView(img));
            root.getChildren().add(ti);
        }
        ttc.setCellValueFactory(param -> 
            new ReadOnlyObjectWrapper<>(param.getValue().getValue())
        );

        ttc.setCellFactory(new Callback<TreeTableColumn<String, String>, TreeTableCell<String, String>>() {
            @Override
            public TreeTableCell<String, String> call(TreeTableColumn<String, String> param) {
                return new TreeTableCell<String, String>() {
                    private ImageView imageView;

                    @Override
                    protected void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);

                        if (!empty && item != null) {
                            if (imageView == null) {
                                imageView = new ImageView(img);
                            }

                            setText(item);
                            setGraphic(imageView);
                        } else {
                            setText(null);
                            setGraphic(null);
                        }
                    }
                };
            }
        });

        ttv.setRoot(root);
    }
}