public class Main extends Game {

    @Override
    public void create() {
        setScreen(new SceneA());
    }
    @Override
    public void dispose() {
    // your SceneA and SceneB here will dispose here after you call setScreen(new ____());
        getScreen().dispose(); 
        System.out.println("\n" + getScreen().getClass().getSimpleName() + " disopsed");
        System.out.println("=========================================================");
    }
}