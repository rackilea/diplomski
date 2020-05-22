public enum Screens {

SPLASH {
    @Override
    protected Screen getScreenInstance( MyGdxGame game ) {
        return new SplashScreen( game );
    }
    @Override
    protected Screen getParentScreen() {
        return Screens.LOGIN;
    }
},
//...
;

protected abstract Screen getScreenInstance( MyGdxGame game );
protected abstract Screen getParentScreen();