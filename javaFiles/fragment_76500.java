stage = new Stage(myViewport, new PolygonBatch());

//...

public void draw(Batch batch, float parentAlpha) {
    //      super.draw(batch, parentAlpha);

    if (fv == null) return;
    //don't need to call begin and end on the batch
    drawMe((PolygonBatch)batch); 
}

public void drawMe(PolygonBatch polyBatch) {
    //...
    //don't need to call begin or end on the batch
}