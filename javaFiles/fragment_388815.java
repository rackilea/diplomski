moveBackward.addListener(new InputListener(){
    @Override
    public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
       motionState=MotionState.NONE;
    }
    @Override
    public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
         motionState=MotionState.DOWN;  // or what you want 
        return true;
    }
});