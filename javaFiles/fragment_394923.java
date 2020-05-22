TiledMap tiledMap;
OrthographicCamera camera;
TiledMapRenderer tiledMapRenderer;

final float WIDTH = 8000;
final float HEIGHT = 4500;
final float num = 3.125f;
@Override
public void show() {
    tiledMap = MapLoader.realm1_level1;
    tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap, num);
    camera = new OrthographicCamera(WIDTH, HEIGHT);
    Gdx.input.setInputProcessor(this);
    camera.zoom += 1f;
    camera.update();
}

@Override
public void render(float delta) {
    Gdx.gl.glClearColor(1, 1, 1, 1);
    Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    tiledMapRenderer.setView(camera);
    tiledMapRenderer.render();
}
// This method was just used for testing to see where 
// the map was or should have been placed.
@Override
public boolean keyDown(int keycode) {
    if (keycode == Input.Keys.LEFT)
        camera.translate(-32, 0);
    if (keycode == Input.Keys.RIGHT)
        camera.translate(32, 0);
    if (keycode == Input.Keys.UP)
        camera.translate(0, 32);
    if (keycode == Input.Keys.DOWN)
        camera.translate(0, -32);
    if (keycode == Input.Keys.NUM_1)
        tiledMap.getLayers().get(0).setVisible(!tiledMap.getLayers().get(0).isVisible());
    return true;
}

@Override
public void resize(int width, int height) {
    camera.position.set(WIDTH, HEIGHT, 0);
    camera.update();
}

@Override
public boolean scrolled(int amount) {
    camera.zoom += amount;
    camera.update();
    return true;
}

@Override
public void dispose() {
    tiledMap.dispose();
}
// And here go the rest of the methods that come from the 
//Screen and the InputProcessor interfaces.