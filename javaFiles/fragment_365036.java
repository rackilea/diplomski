Ball b = new Ball(float pX, float pY, TextureRegion pTextureRegion, PhysicsWorld pWorld, float velocityX, float velocityY, int type) 
{
    @Override
    public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY)
    {
        destroyBall(this);
    }
}