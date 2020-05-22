public class TestGame extends Game implements InputProcessor{

    private SpriteBatch spriteBatch;
    private Sprite sprite;
    private TextureRegion textureRegion;
    private float offset = 20;
    private firstTex,secondTex; 

    @Override
    public void create() {

        spriteBatch=new SpriteBatch();

        textureRegion=new TextureRegion(firstTex=new Texture("im.png"));
        sprite=new Sprite(secondTex=new Texture("xyz.png"));
        sprite.setPosition(100,100);

        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void render() {

        Gdx.gl.glClearColor(1,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        spriteBatch.begin();
        sprite.draw(spriteBatch);
        spriteBatch.draw(textureRegion,sprite.getX()+ offset *MathUtils.cosDeg(sprite.getRotation()),sprite.getY()+(offset)*MathUtils.sinDeg(sprite.getRotation()),sprite.getWidth()/2f,sprite.getHeight()/2f,sprite.getWidth(),sprite.getHeight(),1,1,sprite.getRotation());
        spriteBatch.end();

        if(Gdx.input.isTouched()){
            float rotation=sprite.getRotation();
            rotation++;
            sprite.setRotation(rotation);
        }

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

        float rotation=sprite.getRotation();
        rotation++;
        sprite.setRotation(rotation);

        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
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

    @Override
    public void dispose(){
       firstTex.dispose();
       secondTex.dispose();
       spriteBatch.dispose();
   }
}