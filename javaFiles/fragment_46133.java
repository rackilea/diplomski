public class ViewController implements IViewController{

@AssistedInject
public ViewController(@Assisted int i){
    final String LANGUAGE_BUNDLE = "languageBundle";
    final String FXML = "View.fxml";

    try{
        ResourceBundle resourceBundle = ResourceBundle.getBundle(LANGUAGE_BUNDLE, Locale.GERMAN, this.getClass().getClassLoader());
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(FXML), resourceBundle, new JavaFXBuilderFactory());
        fxmlLoader.setController(this);
        Stage second = new Stage();
        second.setScene(new Scene(fxmlLoader.load()));
        second.show();
    }catch (IOException e){
        e.printStackTrace();
    }
    System.out.println("ViewController constructor called with: " + i);
}