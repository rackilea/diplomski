player = new Sprite(PlayerX, PlayerY, mHippoTextureRegion){
    @Override
    public boolean onAreaTouched(final TouchEvent pSceneTouchEvent,
                                 final float pTouchAreaLocalX,
                                 final float pTouchAreaLocalY) {
        this.setX(pSceneTouchEvent.getX() - this.getWidth() / 2);
        return true;
     }
};