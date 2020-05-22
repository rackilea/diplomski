public class DesktopApplication extends Application implements Runnable {

    Parent myLayout;
    Parent mainLayout;
    Scene scene;
    public static Stage stage; // if possible make this private and non static

    public DesktopApplication() {
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Title");
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.initStyle(StageStyle.UNDECORATED);

        int width = (int) Screen.getPrimary().getBounds().getWidth();
        int height = (int) Screen.getPrimary().getBounds().getHeight();

        mainLayout = new HBox();
        mainLayout.getChildren().add(new Text("hello!"));
        myLayout = new MyLayout(this);

        scene = new Scene(myLayout,width,height);

        primaryStage.setScene(scene);
        primaryStage.setFullScreen(true);
        primaryStage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        primaryStage.show();

        primaryStagePublic = primaryStage;

    }
    ...