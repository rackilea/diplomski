final Bitmap bitmap = BitmapFactory.decodeFile(bitmapUri.getPath());

theBackground.queueEvent(new Runnable() {
    @Override
    void run() {
        mImageWidth = bitmap.getWidth();
        mImageHeight = bitmap.getHeight();
        mTexRenderer.updateTextureSize(mImageWidth, mImageHeight);

        GLES20.glBindTexture(GLES20.GL_TEXTURE_2D, mTextures[0]);
        GLUtils.texImage2D(GLES20.GL_TEXTURE_2D, 0, bitmap, 0);

        bitmap.recycle();
    }
});

theBackground.requestRender();