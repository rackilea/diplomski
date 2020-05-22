OrthographicCamera camera;
Viewport viewport;
SpriteBatch batch;

@Override
public void create () {
    camera = new OrthographicCamera(); // we create a OrthographicCamera
    viewport = new ExtendViewport(WORLD_WIDTH, WORLD_HEIGHT, camera); // we create a new Viewport with our camera and we will display our world 300 x 250 units
    batch = new SpriteBatch(); // we create a new SpriteBatch for draw our textures
}