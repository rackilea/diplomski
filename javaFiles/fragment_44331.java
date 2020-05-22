public class LoadingScreen extends Screen {

    private boolean firstFrame = true;
    private Texture texture;
    private ExtendViewport viewport;
    private MyGame game;
    private SpriteBatch batch;
    private static final float LOAD_IMAGE_WIDTH = 480, LOAD_IMAGE_HEIGHT = 600;
    // Use whatever the loading image dimensions are.

    public LoadingScreen (MyGame game, SpriteBatch batch){
        this.game = game;
        this.batch = batch;
        viewport = new ExtendViewport(LOAD_IMAGE_WIDTH, LOAD_IMAGE_HEIGHT);
    }

    public void resize (int width, int height) {
        viewport.update(width, height, false);
        viewport.getCamera().position.set(LOAD_IMAGE_WIDTH / 2, LOAD_IMAGE_HEIGHT / 2, 0);
        viewport.getCamera().update();
    }

    public void show (){} // do nothing

    public void render (float delta) {

        if (firstFrame){
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
            viewport.apply();
            batch.setProjectionMatrix(viewport.getCamera().combined);
            batch.setBlendingDisabled(true);
            batch.begin();
            batch.draw(texture, 0, 0, LOAD_IMAGE_WIDTH, LOAD_IMAGE_HEIGHT);
            batch.end();
            firstFrame = false;
        } else {
            loadEverything(); 
            // Notice you don't actually render anything so what you previously drew stays on the screen.
        }
    }

    private void loadEverything(){
        // load your font, assets, prefs, etc.

        texture.dispose();
        main.setGameScreen();
    }
}