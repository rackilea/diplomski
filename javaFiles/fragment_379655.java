public class TestGame extends Game {

    TiledMap map;
    OrthographicCamera camera;
    TiledMapRenderer tiledMapRenderer;

    @Override
    public void create() {

        TmxMapLoader tmxMapLoader=new TmxMapLoader();

        map=tmxMapLoader.load("ste_barbe_map.tmx");

        TiledMapTileLayer layer=(TiledMapTileLayer) map.getLayers().get(1);

        tiledMapRenderer= new OrthogonalTiledMapRenderer(map);
        camera=new OrthographicCamera();
        camera.update();
        float widthHeightRatio=1.66f; 
        camera.setToOrtho(false,(layer.getWidth()*layer.getTileWidth())/widthHeightRatio,layer.getHeight()*layer.getTileHeight());
    }

    @Override
    public void render() {

        Gdx.gl.glClearColor(1,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        tiledMapRenderer.setView(camera);
        tiledMapRenderer.render();
    }
}