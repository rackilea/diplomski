public class Try1 extends Application {

    private ImageView background = new ImageView(img);

    private final ChangeListener<Number> windowWidthResized = (ObservableValue<? extends Number> ov, Number t, Number t1) -> {
    windowResized();
};

    private final ChangeListener<Number> windowHeightResized = (ObservableValue<? extends Number> ov, Number t, Number t1) -> {
    windowResized();
};

    private void windowResized(){
        double newHeight = scene.getHeight();
        double newWidth = scene.getWidth();
        centerBackgroundImage(newWidth, newHeight);
    }

    private void centerBackgroundImage(double width, double height) {
            double translateX = width/2 - img.getWidth()/2;
            System.out.println(translateX);
            background.setTranslateX(translateX);

            double translateY = height/2 - img.getHeight()/2;
            System.out.println(translateY);
            background.setTranslateY(translateY);
    }

    @Override
    public void start(Stage primaryStage) {
        try {


            //BorderPane()
            //https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/BorderPane.html
            BorderPane borderPane = new BorderPane();

            //jot down the width and height of the scene
            double width = 600;
            double height = 600;

            //File(String pathname)
            //https://docs.oracle.com/javase/8/docs/api/java/io/File.html
            File file = new File("./src/application/resourcesa/black_clock.png");

            Image img = null;
            if(file.exists()) {
                //Image(InputStream is)
                //https://docs.oracle.com/javase/8/javafx/api/javafx/scene/image/Image.html
                img = new Image(file.getAbsoluteFile().toURI().toString());
            } else {
                //Image(String url)
                //https://docs.oracle.com/javase/8/javafx/api/javafx/scene/image/Image.html
                img = new Image("https://raw.githubusercontent.com/4nds/CenteredBackgroundImage/master/Background/src/application/resources/black_clock.png");
            }


            background.setImage(img);

            //..center the background
            centerBackgroundImage(width, height);

            //Button(String text)
            //https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/Button.html
            Button btn = new Button("Center");

            //https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/BorderPane.html#setCenter-javafx.scene.Node-
            borderPane.setCenter(btn);

            //make root with BorderPane and background image
            Group root = new Group (background, borderPane);

            Scene scene = new Scene(root, width, height);

            //add callbacks to handle window resize
            scene.heightProperty().addListener(windowResized);
            scene.widthProperty().addListener(windowWidthResized);        

            primaryStage.setScene(scene);

            //this lines set borderPane's dimensions to be the same as scene
            borderPane.prefHeightProperty().bind(scene.heightProperty());
            borderPane.prefWidthProperty().bind(scene.widthProperty());

            primaryStage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}