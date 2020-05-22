public class SpritesOrthogonalTiledMapRenderer extends OrthogonalTiledMapRenderer {

    //Override whichever constructor(s) you need
    public SpritesOrthogonalTiledMapRenderer (TiledMap map, Batch batch) {
        super(map, batch);
    }

    @Override
    public void renderObject(MapObject object) {
        super.renderObject(object);
        if(object instanceof SpriteMapObject) {
            ((SpriteMapObject) object).render(batch);
        }
    }
}