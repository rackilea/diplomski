public class Starts extends Game {

 OrthographicCamera camera;
    public void create() {
        camera=new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
        this.setScreen(new MainMenuScreen(camera));// change screen and pass camera to new screen.
    }

}