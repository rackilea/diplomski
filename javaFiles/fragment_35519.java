private static final float SHIP_MAX_SPEED = 50f; //units per second
private final Vector2 tmpVec2 = new Vector2();
private final Vector3 tmpVec3 = new Vector3();

//...

if (Gdx.input.isTouched()) {  
    camera.unproject(tmpVec3.set(Gdx.input.getX(), Gdx.input.getY(), 0)); //touch point to world coordinate system.
    tmpVec2.set(tmpVec3.x, tmpVec3.y).sub(x, y); //vector from ship to touch point
    float maxDistance = SHIP_MAX_SPEED * Gdx.graphics.getDeltaTime(); //max distance ship can move this frame
    if (tmpVec2.len() <= maxDistance) {
        x = tmpVec3.x;
        y = tmpVec3.y;
    } else {
        tmpVec2.nor().scl(maxDistance); //reduce vector to max distance length
        x += tmpVec2.x;
        y += tmpVec2.y;
    }
}