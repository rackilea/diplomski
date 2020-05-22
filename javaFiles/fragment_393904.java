public class HomeController {

    private Parent parent;
    private Stage stage;
    private Scene scene;


    public HomeController (){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/home.fxml"));
        fxmlLoader.setController(this);
        try {
             parent = (Parent) fxmlLoader.load();
                // set height and width here for this home scene
                scene = new Scene(parent, 1000, 800);
        } catch (IOException e) {
         // manage the exception
        }
    }

    public void displayHomeScreen(Stage stage){
        this.stage = stage;
        stage.setScene(scene); 

        // Must write
        stage.hide()
        stage.show();
    }
}