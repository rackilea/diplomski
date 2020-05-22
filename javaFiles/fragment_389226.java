import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PizzaOrderingSystem extends Application {

    public static void main(final String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage window) throws Exception {

        window.setTitle("Pizza ordering system");
        MenuBar menuBar = new MenuBar();
        Menu orderMenu = new Menu("Order");
        orderMenu.getItems().addAll(new OrderMenu().getmenuItems());
        menuBar.getMenus().add(orderMenu);
        VBox vBox = new VBox(menuBar);
        Scene scene = new Scene(vBox, 300, 300);
        window.setScene(scene);
        window.show();
    }
}

class OrderMenu {

    public ArrayList<MenuItem> menuItems;

    public OrderMenu (){

        menuItems = new ArrayList<>();
        menuItems.add(new Pizza("Margherita",50) );
        menuItems.add(new Pizza("Hawaii", 55));
        menuItems.add(new Pizza("Marinara", 70));
        menuItems.add(new Pizza("Meat Lovers", 70));
        menuItems.add(new Pizza("Calazone", 60));
    }

    public ArrayList<MenuItem> getmenuItems() {
        return menuItems;
    }
}

class Pizza extends MenuItem {

    Pizza(String name, int cost) {
        setText(name +" $"+cost);
        setOnAction(e-> System.out.println(name+ " piza ordered"));
    }
}