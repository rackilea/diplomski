public class MainMenuScreen implements Screen {

final Starts game;
public MainMenuScreen(final Starts game) {
    this.game = game;

}

@Override
public void render(float delta) {
    Gdx.gl.glClearColor(0, 0, 0.2f, 1);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

    game.camera.update();
    game.batch.setProjectionMatrix(game.camera.combined);

    game.batch.begin();
    game.font.draw(...);
    game.font.draw(...);
    game.batch.end();

    if (Gdx.input.isTouched()) {
        game.setScreen(new AnotherScreen(game));
        dispose();
    }
}

}