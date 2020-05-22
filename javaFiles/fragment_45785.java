public void loadSplashResources() {
    BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/splash/");
    mSplashTextureAtlas = new BitmapTextureAtlas(mActivity.getTextureManager(), 480, 800, TextureOptions.BILINEAR);
    mSplashTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mSplashTextureAtlas, mActivity, "splash.png", 0, 0);
    mSplashTextureAtlas.load();
    mFont1 = FontFactory.create(mActivity.getFontManager(), mActivity.getTextureManager(), 256, 256, Typeface.create(Typeface.DEFAULT, Typeface.NORMAL), 10, Color.GRAY);
    mFont1.load();
}