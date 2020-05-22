public void draw(Batch batch, float parentAlpha) {
    //      super.draw(batch, parentAlpha);

    if (fv == null) return;

    batch.end();
    drawMe(batch.getProjectionMatrix());
    batch.begin();
}

public void drawMe(Matrix4 projection) {
    polyBatch.setProjectionMatrix(projection);
    //...
}