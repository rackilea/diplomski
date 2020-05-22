import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

//main class
public class UpdateViewByMenu extends Application {

    private Controller controller;

    @Override
    public void start(Stage stage) throws Exception {

        BorderPane root = new BorderPane();
        controller = new Controller();
        root.setTop(controller.getMenu());
        root.setBottom(controller.getView());
        Scene scene = new Scene(root, 350,200);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) { launch(args);}
}

//controller which "wires" view to model
class Controller {

    private Model model;
    private View view;
    private TopMenu menu;

    public Controller() {
        model = new Model();
        view = new View();
        menu = new TopMenu();
        //wire up menu to model : menu changes update model
        menu.getMenuTextProperty().addListener(
                e-> model.setCourseID(menu.getMenuTextProperty().get()));
        //wire model to view: change in model update view
        view. geLabelTextProerty().bind(model.getCourseIDProperty());
        //set initial value to show
        menu.getMenuTextProperty().set("Not set");
    }

    Model     getModel() {return model;}
    Pane      getView()  { return view;}
    MenuBar  getMenu()  { return menu; }
}

//model which represent the data, in this case label info
class Model{

    SimpleStringProperty courseIdProperty;
    Model(){
        courseIdProperty = new SimpleStringProperty();
    }

    StringProperty getCourseIDProperty() {

        return courseIdProperty;
    }

    void setCourseID(String id) {

        courseIdProperty.set(id);
    }
}

//represents main view, in this case a container for a label
class View extends HBox {

    private Label courseID;

    View() {
        courseID = new Label();
        getChildren().add(courseID);
    }

    StringProperty geLabelTextProerty() {

        return courseID.textProperty();
    }
}

//menu
class TopMenu extends MenuBar{

    SimpleStringProperty menuTextProperty;

    TopMenu() {
        menuTextProperty = new SimpleStringProperty();
        Menu menu = new Menu("Select id");
        MenuItem item1 =  getMenuItem("10021");
        MenuItem item2 =  getMenuItem("10022");
        MenuItem item3 =  getMenuItem("10023");
        MenuItem item4 =  getMenuItem("10024");
        menu.getItems().addAll(item1, item2, item3, item4);
        getMenus().add(menu);
    }

    MenuItem getMenuItem(String text) {

        MenuItem item =  new MenuItem(text);
        item.setOnAction(e -> menuTextProperty.set(item.textProperty().get()));
        return item;
    }

    StringProperty getMenuTextProperty() {

        return menuTextProperty;
    }
}