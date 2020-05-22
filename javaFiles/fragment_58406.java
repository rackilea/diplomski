public class DesktopLauncher {
  public static void main(string[] args) {
    LwjglApplicationConfiguration config = new LwgjlApplicationConfiguration();
    new LwjglApplication(new Picture(), config);
  }

  public static class Picture extends ApplicationAdapter {
    public Picture(){}
    PictureGeneratorImpl generator;

    public void create() {
      generator = new PictureGeneratorImpl();
    }

    public void render() {
      generator.generatePicture();
      generator.exit();
    }

    public void dispose() {
      generator.dispose();
    }
  }
}