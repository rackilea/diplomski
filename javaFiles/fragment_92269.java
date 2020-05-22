OrthogonalTiledMapRenderer renderer =
    new OrthogonalTiledMapRenderer(myMap, 1 / 16f); // Change this to your render scale
                                                  //e.g. 1/32f means your tiles are 32px wide

OrthographicCamera camera = new OrthographicCamera(16, 9); //viewport size: 16x9

...

//Inside your class that implements Screen or extends Game
public void render(float delta) {
    ...
    renderer.setView(camera);
    renderer.render();
    ...
}