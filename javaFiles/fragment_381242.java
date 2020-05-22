public boolean touchDown(int screenX, int screenY, int pointer, int button) {
 if (screenX < Gdx.graphics.getWidth()/2)
     touchLeft = true;
 else
     touchRight = true;
 }