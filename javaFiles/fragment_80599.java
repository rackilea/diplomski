public class ReleaseDetector {

    boolean touched = false;

    public void releaseListener(MyGdxGame game) { // Argument
        if (Gdx.input.isTouched()) {
            touched = true;
        }
        if (!Gdx.input.isTouched() && touched){
            game.addCounter();                    // Callback
            touched = false;
        }
    }
}