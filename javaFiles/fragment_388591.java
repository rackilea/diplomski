public class RootLayoutController {

    // Reference to the main application
    @SuppressWarnings("unused")
    private MainApp mainApp;

    // ...


    /**
     * Initializes the controller class.
     */
    @FXML
    private void initialize() {
        try {
            VBox box = FXMLLoader.load(getClass().getResource("DrawerContent.fxml"));
            drawer.setSidePane(box);

            // ...

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
        this.mainApp = mainApp;
    }

}