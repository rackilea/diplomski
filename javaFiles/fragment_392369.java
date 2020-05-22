public class LoginController {

    public LoginController(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login.fxml"));
            fxmlLoader.setController(this);
            fxmlLoader.load();
        } catch (IOException exception) {
            System.out.println("Error loading content.");
            System.exit(0);
        }
    }

}