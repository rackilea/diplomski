if (featherBool) {  
    animationTime+=.01f;
    featherTexture = featherAnimation.getKeyFrame(animationTime);  // <--looping not required so remove second argument
    batch.draw(featherTexture, egg.getX() - featherTexture.getRegionWidth() / 2, fx.getY());
    if(featherAnimation.isAnimationFinished(animationTime))
        featherBool = false;
}