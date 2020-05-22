Gdx.gl.glEnable(GL20.GL_BLEND);
Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);

// now you can draw transparent shapes
startDrawingShapes();

Gdx.gl.glDisable(GL20.GL_BLEND);