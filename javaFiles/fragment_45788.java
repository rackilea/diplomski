@Override
protected Scene onCreateScene() {
    mEngine.registerUpdateHandler(new TimerHandler(2f, new ITimerCallback() {
        public void onTimePassed(final TimerHandler pTimerHandler) {
            mEngine.unregisterUpdateHandler(pTimerHandler);
            mResourceManager.loadGameResources();
            mSceneManager.setScene(SceneType.SCENE_MENU);
            mResourceManager.unloadSplashResources();
        }
    }));