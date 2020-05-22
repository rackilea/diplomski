public enum Screens {

SPLASH(Screens.LOGIN) {
    @Override
    protected Screen getScreenInstance( MyGdxGame game ) {
        return new SplashScreen( game );
    }
},

LOGIN(null) {//...}

;//this semi-colon is expected after the enum values

private final Screens parentScreen;

Screens(Screens parent){//Constructor
    parentScreen = parent;
}

public Screens getParentScreen(){
    return parentScreen;
}

protected abstract Screen getScreenInstance( MyGdxGame game );