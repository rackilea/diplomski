float scaleX = mDisplayWidth / mVideoWidth, scaleY = mDisplayHeight / mVideoHeight; 
    //proportions between screen and frame dimensions
    float scale = mDisplayHeight / Math.abs(by - ay);
    Matrix matrix = new Matrix();
    matrix.reset();
    matrix.setScale(scale / scaleX, scale / scaleY);
    //scaling video
    matrix.postTranslate(-scale * ax, -scale * ay);
    //move video, so the needed part of it will be displayed properly
    mTextureView.setLayoutParams(new FrameLayout.LayoutParams((int) mDisplayWidth, (int) mDisplayHeight));
    mTextureView.setTransform(matrix);
    //updating the Texture view