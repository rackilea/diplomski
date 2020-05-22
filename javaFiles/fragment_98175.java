Vector3 v = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
v = cam.unproject(v);
// now v has your coordinate world system and you can properly make use of it
// you can do now something like:
tap_x = (int) v.x;
tap_y = (int) v.y;