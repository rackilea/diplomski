public void create () {
    camera = new OrthographicCamera(WORLD_WIDTH, WORLD_HEIGHT); // we create a OrthographicCamera and we will display our world 300 x 250 units
    camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0); //we set position of camera, our world point 0,0 is now the bottom left corner in the camera
    batch = new SpriteBatch(); // we create a new SpriteBatch for draw our textures
    texture = new Texture("badlogic.jpg");
}

public void render () {
    camera.update();
    batch.setProjectionMatrix(camera.combined);

    batch.begin();
    batch.draw(texture, 0,0);
    batch.end();
}