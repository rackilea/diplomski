public class Simple implements ApplicationListener {
    private OrthographicCamera camera;
    private SpriteBatch batch;
    private BitmapFont font;
    private GlyphLayout layout;
    String a1 = "aa";
    String a2 = "bb";
    String a3 = "cc";
    int a = 0;

    @Override
    public void create() {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
        batch = new SpriteBatch();
        //Initialize the fields in create()           
        layout = new GlyphLayout();
        font = new BitmapFont();

    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        for (int i = 1; i < 4; i++) {
            //Use them like you do.
            layout.setText(font, "a" + i);
            font.draw(batch, layout, 200 + (15 * i), 200);
        }
        batch.end();
    }
}