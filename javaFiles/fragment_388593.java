public class MainApp extends Application {

    private Stage primaryStage;
    private AnchorPane rootLayout;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Car Manager");

        // Prevent the window resizing
        this.primaryStage.setResizable(false);

        showLogin();
    }

    /**
     * Show the login page
     */
    public void showLogin() {
        try {
            // Load login page
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/Login.fxml"));
            AnchorPane login = (AnchorPane) loader.load();

            // Set the scene containing the login page
            Scene scene = new Scene(login);
            primaryStage.setScene(scene);

            // Give the controller access to the main application
            LoginController controller = loader.getController();
            controller.setMainApp(this);

            // Show the scene
            primaryStage.show();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Initializes the root layout
     */
    public void initRootLayout() {
        try {
            // Load root layout
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = (AnchorPane) loader.load();

            // Give the controller access to the main application
            RootLayoutController controller = loader.getController();
            controller.setMainApp(this);

            // Get the DrawerContentController 

            // really no point in doing that since you don't display the UI you load...
            // FXMLLoader drawerLoader = new FXMLLoader();
            // drawerLoader.setLocation(MainApp.class.getResource("view/DrawerContent.fxml"));
            // drawerLoader.load(); // Load the fxml file (and do nothing with it)
            // DrawerContentController drawerController = drawerLoader.getController();
            // drawerController.setMainApp(this);

            // Show the scene containing the root layout
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}