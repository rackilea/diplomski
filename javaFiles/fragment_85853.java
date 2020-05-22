Gdx.gl10.glMatrixMode(GL10.GL_PROJECTION);
Gdx.gl10.glLoadIdentity();
Gdx.gl10.glMatrixMode(GL10.GL_MODELVIEW);
Gdx.gl10.glLoadIdentity();
mesh.render(GL10.GL_TRIANGLES, 0, 3);

batch.begin();
batch.draw(texture, 10, 10);
batch.end();