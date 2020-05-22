batch.enableBlending();
Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
Gdx.gl.glEnable(GL20.GL_BLEND);
batch.draw(texture,this.getX(),getY());
Gdx.gl.glDisable(GL20.GL_BLEND);
batch.disableBlending();