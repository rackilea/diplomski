public class MyGameDesktop implements NativeFunctions {
    public static void main(String[] args) {
        MyGameDesktop game = new MyGameDesktop();
        new LwjglApplication(new MyGame(game), "MyGame", 800,
             480, false);
    }
    public void openURL(String url) {
        // Your implementation to open URL on dekstop
    }
}