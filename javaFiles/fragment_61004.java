public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println(Screen.getPrimary().getVisualBounds().getWidth());
        new Thread(){
            public void run() {
                try{
                    this.sleep(30000);
                } catch (InterruptedException e) {
                    // ignore
                }

System.out.println(Screen.getPrimary().getVisualBounds().getWidth());
            }
        }.start();
    }
    public static void main(String[] args) { launch(args); }
}