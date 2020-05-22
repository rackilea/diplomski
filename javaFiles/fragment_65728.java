public class MyGdxGame extends ApplicationAdapter {
    SpriteBatch batch;
    Texture background;
    Texture ballTexture;
    Ball ball;

    @Override
    public void create () {
        batch = new SpriteBatch();
        background = new Texture("gamebackground.png");

        ballTexture = new Texture("ball2.png");
        ballTexture.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);

        ball = new Ball();
    }

    @Override
    public void render () {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // don't forget to clear screen

        if (Gdx.input.justTouched())
            ball.velocity.y += 100;
        ball.update();

        batch.begin();
        float scaleFactor = 2.0f;
        batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.draw(ballTexture, ball.position.x, ball.position.y, ballTexture.getWidth() * scaleFactor, ballTexture.getHeight() * scaleFactor);
        batch.end();
    }

    @Override
    public void dispose () {
        batch.dispose();
        background.dispose();
        ballTexture.dispose();
    }
}