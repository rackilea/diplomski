TmxMapLoader loader = new TmxMapLoader();
map = loader.load("ste_barbe_map.tmx");
tiledMapRenderer = new OrthogonalTiledMapRenderer(map);
TiledMapTileLayer layer=(TiledMapTileLayer)map.getLayers().get(0);

float w=layer.getTileWidth()*layer.getWidth();   // 100*34
float h=layer.getTileHeight()*layer.getHeight();  // 100*34

camera=new OrthographicCamera(w,h);
// you can manually set camera viewport 
//camera=new OrthographicCamera(100*34,100*34);