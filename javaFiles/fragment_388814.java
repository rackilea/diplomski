if(Gdx.input.isKeyPressed(Input.Keys.DOWN)) motionState = MotionState.DOWN;
if(Gdx.input.isKeyPressed(Input.Keys.UP)) motionState=MotionState.UP;
if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) motionState=MotionState.LEFT;
if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) motionState=MotionState.RIGHT;

if(motionState.update(player)) motionState=MotionState.NONE;