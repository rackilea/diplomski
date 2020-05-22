public class myGame extends ApplicationAdapter {

public OrthographicCamera camera;
public Viewport viewPort;
private SpriteBatch batch;

public myGame() {

}

@Override
public void create() {
    float w = Gdx.graphics.getWidth();
    float h = Gdx.graphics.getHeight();

    camera = new OrthographicCamera();
    camera.position.set(0, 0, 0);
    camera.update();
    camera.setToOrtho(false, 1280, 800);
    viewPort = new FillViewport(1280, 800, camera);


}

@Override
public void dispose() {
    batch.dispose();
}





@Override
public void render() {
    Gdx.gl.glClearColor(1, 1, 1, 1);
    Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
    float deltaTime = Gdx.graphics.getDeltaTime();
    batch.setProjectionMatrix(camera.combined);
    batch.begin();
    batch.draw(sprie,0,0)
    batch.end();

}

@Override
public void resize(int width, int height) {
    viewPort.update(width, height);
}

@Override
public void pause() {
}

@Override
public void resume() {
}
}
// don't copy paste it . just try to understand and implement it.