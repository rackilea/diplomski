public class MyGdxGame implements ApplicationListener {
    OrthographicCamera mCamera;
    SpriteBatch mBatch;
    Texture mTexture, mMap;
    float touchX, touchY;
    float spriteX, spriteY, speed = 120;

    final float CAMERA_WIDTH = 480, CAMERA_HEIGHT = 320;

    @Override public void create() {
        mCamera = new OrthographicCamera(CAMERA_WIDTH, CAMERA_HEIGHT);

        mBatch = new SpriteBatch();
        mTexture = new Texture(Gdx.files.internal("data/logo.png"));
        mMap = new Texture(Gdx.files.internal("data/sc_map.png"));
    }

    @Override public void dispose() {
        mTexture.dispose();
        mMap.dispose();
    }

    @Override public void render() {
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

        updateInput(Gdx.graphics.getDeltaTime());
        mCamera.update();
        mBatch.setProjectionMatrix(mCamera.combined);
        mBatch.begin();
        drawD();
        mBatch.end();
    }

    @Override public void resize(final int width, final int height) {}

    @Override public void pause() {}

    @Override public void resume() {}

    public void drawD() {
        mBatch.draw(mMap, -spriteX - (mMap.getWidth() / 2), spriteY - (mMap.getHeight() / 2));
        mBatch.draw(mTexture, -32, -32, 64, 64);
    }

    public void updateInput(final float delta) {
        if (Gdx.input.justTouched()) {
            touchX = Gdx.input.getX() - (Gdx.graphics.getWidth() / 2);
            touchY = Gdx.input.getY() - (Gdx.graphics.getHeight() / 2);
        }
        final float dv = delta * speed;
        if (Math.abs(touchX - spriteX) > 1) {
            if (spriteX < touchX) {
                spriteX += dv;
            }
            if (spriteX > touchX) {
                spriteX -= dv;
            }
        }
        if (Math.abs(touchY - spriteY) > 1) {
            if (spriteY > touchY) {
                spriteY -= dv;
            }
            if (spriteY < touchY) {
                spriteY += dv;
            }
        }
    }
}