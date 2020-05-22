public class PolyActor extends Actor {

  PolygonRegion polygonRegion;

  public PolyActor(PolygonRegion region){
      this.polygonRegion=region;
  }

  @Override
  public void draw(Batch batch, float parentAlpha) {

    Color color = getColor();
    batch.setColor(color.r, color.g, color.b, color.a * parentAlpha);
    ((PolygonSpriteBatch)batch).draw(polygonRegion,getX(),getY());
  }
}