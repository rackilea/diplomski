import java.io.IOException;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBasicCloseTransition;

import gn.kahere.car.manager.MainApp;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class RootLayoutController {

    // Reference to the main application

    // @SuppressWarnings("unused") // hmm if it's unused, I probably don't need it...

    // private MainApp mainApp;

    private DrawerContentController drawerContentController ;

    @FXML
    private JFXHamburger hamburger;

    @FXML
    private JFXDrawer drawer;


    /**
     * Controller
     */
    public RootLayoutController() {

    }

    /**
     * Initializes the controller class.
     */
    @FXML
    private void initialize() {
        try {
            FXMLLoader drawerContentLoader = new FXMLLoader(getClass().getResource("DrawerContent.fxml"));
            VBox box = drawerContentLoader.load();
            drawer.setSidePane(box);

            drawerContentController = drawerContentLoader.getController();

            HamburgerBasicCloseTransition burgerTask = new HamburgerBasicCloseTransition(hamburger);
            burgerTask.setRate(-1);

            hamburger.addEventHandler(MouseEvent.MOUSE_PRESSED, (e) -> {
                burgerTask.setRate(burgerTask.getRate() * -1);
                burgerTask.play();

                if(drawer.isShown())
                    drawer.close();
                else
                    drawer.open();
            });
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Is called by the main application to give a reference back to itself
     * 
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        // this.mainApp = mainApp;

        // pass the main app to the drawerContentController:
        drawerContentController.setMainApp(mainApp);
    }

}