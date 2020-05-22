public void render(float delta) {

    Gdx.gl.glClearColor( 0, 0, 0, 1); // Clear the screen with a solid color
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

    if(isTouching == true) { // check for touching
      batch.begin();
        batch.draw(pixel, 100, 100, 100, 100);
      batch.end();
    }
}