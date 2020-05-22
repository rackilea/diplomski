public class Main extends Application {

    @Override
    public void start(Stage stageA) throws Exception{
        Parent viewA = FXMLLoader.load(getClass().getResource("view_a.fxml"));
        Parent viewB = FXMLLoader.load(getClass().getResource("view_b.fxml"));

        stageA.setTitle("View A");
        stageA.setScene(new Scene(viewA));
        stageA.show();

        Stage stageB = new Stage();
        stageB.setTitle("View B");
        stageB.setScene(new Scene(viewB));
        stageB.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}