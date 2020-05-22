public class App extends Application {

    private static final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);

    @Override
    public void start(Stage primaryStage) throws Exception {
        // should fix name, you should not start your own pacakge names "java"
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/java/com/akos/fxml/Main.fxml"));
        loader.setControllerFactory(context::getBean);
        Scene scene = new Scene(loader.load());
        primaryStage.setScene(scene);
        primaryStage.show();
    }  

    public static void main(String[] args) {
        launch(args);
    }    
}