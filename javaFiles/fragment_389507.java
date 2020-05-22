public class GdxTest extends ApplicationAdapter implements InputProcessor{

    ExtendViewport viewport;
    SpriteBatch batch;
    Sprite sprite;
    Texture texture;
    Vector2 touchDown,drag,spritePos;

    @Override
    public void create() {

        viewport=new ExtendViewport(400,640);

        touchDown =new Vector2();
        drag =new Vector2();
        spritePos=new Vector2();

        batch=new SpriteBatch();
        sprite=new Sprite(texture=new Texture("badlogic.jpg"));
        sprite.setSize(100,100);

        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        sprite.draw(batch);
        batch.end();

        if(Gdx.input.isTouched()){

            Vector2 diff= drag.cpy().sub(touchDown);
            diff.nor();
            touchDown.set(drag);
            spritePos.add(diff.scl(3));
        }

        sprite.setPosition(spritePos.x-sprite.getWidth()/2,spritePos.y-sprite.getHeight()/2);
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width,height);
    }

    @Override
    public void dispose() {
        texture.dispose();
        batch.dispose();
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {

        touchDown.set(screenX,screenY);
        viewport.unproject(touchDown);

        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {

        touchDown.set(0,0);
        drag.set(0,0);

        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {

        drag.set(screenX,screenY);
        viewport.unproject(drag);

        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}