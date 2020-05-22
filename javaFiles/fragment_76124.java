import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.CustomMenuItem;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MWE extends Application {

    private static Label label(final String text) {
        final Label label = new Label(text);
        label.addEventFilter(MouseEvent.MOUSE_MOVED, e -> label.requestFocus());
        label.setMaxWidth(200);
        final Background background = label.getBackground();
        label.setOnMouseEntered(e -> label.setBackground(new Background(new BackgroundFill(Color.GRAY.brighter(), CornerRadii.EMPTY, Insets.EMPTY))));
        label.setOnMouseExited(e -> label.setBackground(background));
        // Do something on mouse press; in real world scenario, also hide menu
        label.setOnMousePressed(e -> {
            if (e.isPrimaryButtonDown()) {
                System.out.println(label.getText());
                e.consume();
            }
        });
        return label;
    }

    @Override
    public void start(Stage primaryStage) {
        final Menu menu = new Menu("MENU");

        final List<String> options = Arrays.asList(
                "AbC",
                "dfjksdljf",
                "skdlfj",
                "stackoverflow","ssldkfjsdaf", "sjsdlf", "apple juice", "banana", "mango", "sdlfkjasdlfjsadlfj", "lkjsdflsdfj",
                "stackoverflow","ssldkfjsdaf", "sjsdlf", "apple juice", "banana", "mango", "sdlfkjasdlfjsadlfj", "lkjsdflsdfj",
                "stackoverflowstackoverflowstackoverflowstackoverflowstackoverflowstackoverflow","ssldkfjsdaf", "sjsdlf", "apple juice", "banana", "mango", "sdlfkjasdlfjsadlfj", "lkjsdflsdfj");

        final StringProperty currentSelection = new SimpleStringProperty(null);

        final TextField fuzzySearchField = new TextField(null);
        final CustomMenuItem fuzzySearchItem = new CustomMenuItem(fuzzySearchField, false);
        fuzzySearchItem.setDisable(true);
        // TODO unfortunately we seem to have to grab focus like this!
        fuzzySearchField.addEventFilter(MouseEvent.MOUSE_MOVED, e->{fuzzySearchField.requestFocus(); fuzzySearchField.selectEnd();});
        final ObservableList<String> currentMatches = FXCollections.observableArrayList();
        // just some dummy matching here
        fuzzySearchField.textProperty().addListener((obs, oldv, newv) -> currentMatches.setAll(options.stream().filter(s -> s.toLowerCase().contains(newv)).collect(Collectors.toList())));
        final VBox labels = new VBox();
        currentMatches.addListener((ListChangeListener<String>) change -> labels.getChildren().setAll(currentMatches.stream().map(MWE::label).collect(Collectors.toList())));
        final CustomMenuItem labelItem = new CustomMenuItem(labels, false);
        menu.getItems().setAll(fuzzySearchItem, labelItem);
        fuzzySearchField.textProperty().addListener((obs, oldv, newv) -> currentSelection.setValue(currentMatches.size() > 0 ? currentMatches.get(0) : null));
        fuzzySearchField.setText("");

        menu.setOnShown(e -> fuzzySearchField.requestFocus());
        final MenuButton button = new MenuButton("menu");
        button.getItems().setAll(menu);

        Platform.runLater(() -> {
            final Scene scene = new Scene(button);
            primaryStage.setScene(scene);
            primaryStage.show();
        });

    }
}