public class Main extends Application {

    public static void main(String[] args) { launch(args); }

    @Override
    public void start(Stage primaryStage) {//Removed throws Exception
        BackgroundImage backgroundImage = new BackgroundImage( 
                new Image( getClass().getResource("src/sample/Image/backg.jpg").toExternalForm()),
                BackgroundRepeat.NO_REPEAT, 
                BackgroundRepeat.NO_REPEAT, 
                BackgroundPosition.DEFAULT, 
                BackgroundSize.DEFAULT);
        Background background = new Background(backgroundImage);

        Button button = new Button( "Click me!");
        //button.setBackground(background);Not needed

        VBox vBox = new VBox();//A container which holds all the nodes
        vBox.setBackground(background);//Set the Container Background
        vBox.getChildren().add(button);//Add Nodes

        Scene scene = new Scene(vBox, 600, 400);//Parameters are Parent and width and height of your scene

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}