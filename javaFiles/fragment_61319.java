static final Vector3 VEC = new Vector3(); // reusuable static member to avoid GC churn
private float lastX; //member variable for tracking finger movement

//In your game logic:
if (Gdx.input.isTouching()){
    VEC.set(Gdx.input.getX(), Gdx.input.getY(), 0);
    camera.unproject(VEC);
}

if (Gdx.input.justTouched())
    lastX = VEC.x; //starting point of drag
else if (Gdx.input.isTouching()){ // dragging
    float deltaX = VEC.x - lastX; // how much finger has moved this frame
    lastX = VEC.x; // for next frame

    // Since you're working with integer units, you can round position
    int blockDelta = (int)Math.round(deltaX);

    for (DownBlocks downBlock : getBlocks()){
        downBlock.x += blockDelta;
    }
}