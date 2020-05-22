import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class RecursivelyAddMenuAndSubMenu extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        String menu1 = "File > Open";
        String menu2 = "File > Close";
        String menu3 = "File > Recently closed > File1";
        String menu4 = "File > Recently closed > File2";
        String menu5 = "File > Recently closed > File3";
        String menu6 = "File > Recently closed > File4";
        String menu7 = "File > Recently closed > File5";
        String menu8 = "File > Recently closed > File5 > something";

        CustomMenuBar customMenuBar = new CustomMenuBar();
        customMenuBar.addMenu(menu1);
        customMenuBar.addMenu(menu2);
        customMenuBar.addMenu(menu3);
        customMenuBar.addMenu(menu4);
        customMenuBar.addMenu(menu5);
        customMenuBar.addMenu(menu6);
        customMenuBar.addMenu(menu7);
        customMenuBar.addMenu(menu8);

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(customMenuBar);
        Scene scene = new Scene(borderPane);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    class CustomMenuBar extends MenuBar {

        private Menu currentMenu;
        private Menu head;

        void addMenu(String menu) {
            String tokens[] = splitMenusInHalf(menu);

            // we found something like "x -> y ... "
            if (tokens.length > 1) {

                // search for the current root if it contains
                // the menu we are about to create
                currentMenu = this.getMenu(tokens[0], head);
                boolean isAdded = true;

                // if not create it
                if (currentMenu == null) {
                    currentMenu = new Menu(tokens[0]);
                    isAdded = false;
                }

                // find out if there was a previous Menu created
                // if so the current is a sub-menu of the previous one
                if (head == null) {
                    head = currentMenu;
                    if (!isAdded) {
                        this.getMenus().add(currentMenu);
                    }
                } else {
                    if (!isAdded) {
                        // otherwise add the current Menu as sub-menu
                        head.getItems().add(currentMenu);
                    }
                    // set the Current "head" the sub-menu
                    head = currentMenu;
                }
                // Recursive check for more menus or menuItems
                addMenu(tokens[1]);
            } else {
                // If found only something like "x" which is MenuItem
                currentMenu.getItems().add(new MenuItem(tokens[0]));
                // reset everything for the next addMenu call
                currentMenu = null;
                head = null;
            }
        }

        private Menu getMenu(String menuText, Menu root) {
            if (root == null) {
                ObservableList<Menu> allMenus = this.getMenus();
                for (Menu m : allMenus) {
                    if (m.getText().equals(menuText)) {
                        return m;
                    }
                }
            } else {
                ObservableList<MenuItem> allMenus = root.getItems();
                for (MenuItem m : allMenus) {
                    if (m.getText().equals(menuText)) {
                        // We are about to convert MenuItem to Menu
                        if (!(m instanceof Menu)) {

                            // Get the previous menuItem location
                            int index = allMenus.indexOf(m);
                            // Remove it
                            allMenus.remove(m);
                            // Create a new Menu with the previous MenuItem text
                            m = new Menu(menuText);
                            // Add it to the correct location
                            allMenus.add(index, m);
                        }
                        return (Menu) m;
                    }
                }
            }
            return null;
        }

        private String[] splitMenusInHalf(String menuText) {
            String[] menuChain = menuText.split("\\s*>\\s*", 2);
            for (int i = 0; i < menuChain.length; i++)
                menuChain[i] = menuChain[i].trim();
            return menuChain;
        }
    }
}