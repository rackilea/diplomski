private void drawGround(){
    viewport.x += 2;
    for(Rectangle r : mArrayGround) {
        if(r.x + r.width > viewport.x && r.x < viewport.x + viewport.width) {
            mStage.getSpriteBatch().draw(mTextureGround, viewport.x - r.x, r.y);
        }
    }
}