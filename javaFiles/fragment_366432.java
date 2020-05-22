public class VendorManagementSystem extends Application {

    @Override
    public void start(Stage primaryStage) {

        Controller controller = new Controller();
        View view = new View(controller);

        Scene scene = new Scene(view);
        primaryStage.setHeight(450);
        primaryStage.setWidth(650);
        primaryStage.setTitle("Vendor Management System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}