public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

System.out.println(java.awt.Toolkit.getDefaultToolkit().getScreenSize());
        Thread.sleep(30000);

System.out.println(java.awt.Toolkit.getDefaultToolkit().getScreenSize());
    }
    public static void main(String[] args) { launch(args); }
}