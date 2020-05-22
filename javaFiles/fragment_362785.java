@Override
public void render (float delta) {
    camera.update(); //update our camera every frame
    batch.setProjectionMatrix(camera.combined); //say the batch to only draw what we see in our camera

    batch.begin();
    batch.draw(texture, 0,0); //draw our texture on point 0,0 bottom left corner
    batch.end();
}