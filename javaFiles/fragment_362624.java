public class Launcher {
  public static void main(String[] args) {
    System.setProperty("com.apple.mrj.application.apple.menu.about.name", "Hello World!");
    JFrame jframe = new MyJFrame();
    jframe.setVisible(true);
  }
}