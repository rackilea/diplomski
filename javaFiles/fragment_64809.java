public class WorldSimGame extends ApplicationAdapter {

    private OrthographicCamera camera;
    private SpriteBatch batch;
    private Texture texture;

    public WorldSimGame() { }

    @Override
    public void create(){
        //Create texture, batch and camera
        texture = new Texture(Gdx.files.internal("badlogic.jpg"));
        batch = new SpriteBatch();
        camera = new OrthographicCamera(60,60);
    }

    @Override
    public void render(){
        //clear screen
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        moveCamera();
        //update camera that he recalculate his position and Matrix
        camera.update();

        batch.setProjectionMatrix(camera.combined); //set batch to draw what the camera sees
        batch.begin();
        batch.draw(texture,0,0); //draw texture
        batch.end();
    }

    private void moveCamera(){
        //move camera
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            camera.translate(4,0);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            camera.translate(-4,0);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.UP)){
            camera.translate(0,4);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            camera.translate(0,-4);
        }
    }
}