public class MyGdxGame extends Game implements ApplicationListener {
    public SpriteBatch batch;
    public AssetManager assets;

    @Override
    public void create () {
        batch = new SpriteBatch();
        assets = new AssetManager();

        this.setScreen(new LoadingScreen(this));
    }

    @Override
    public void render () {
        super.render();
    }
}