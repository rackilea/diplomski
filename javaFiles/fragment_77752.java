public class TestGame extends Game {

    SpriteBatch spriteBatch;
    Sprite ball;
    Texture ballTex;
    private int spriteRotationSpeed=1;

    @Override
    public void create() {

        spriteBatch=new SpriteBatch();
        ballTex=new Texture("image/bone.png");
        ball=new Sprite(ballTex);
        ball.setSize(50,50);
        ball.setOrigin(25,25);
        ball.setPosition(0,0);


    }

    @Override
    public void render() {
        super.render();

        Gdx.gl.glClearColor(1,1,1,1);
        gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        spriteBatch.begin();
        ball.draw(spriteBatch);
        spriteBatch.end();
        rotateSprite();
    }

    private void rotateSprite(){

        float rotation=ball.getRotation();
        rotation+=spriteRotationSpeed;
        if(rotation>360)
            rotation-=360;
        ball.setRotation(rotation);
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
    }

    @Override
    public void dispose() {
        super.dispose();
        ballTex.dispose();
        spriteBatch.dispose();
    }
}