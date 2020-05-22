@Override
protected void onCreateResources() {

    mResourceManager = ResourceManager.getInstance();
    mResourceManager.prepare(this);
    mResourceManager.loadSplashResources();
    mSceneManager = SceneManager.getInstance();

}