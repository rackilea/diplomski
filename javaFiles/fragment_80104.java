public GameScreen currentScreen=GameScreen.MENU_SCREEN;

@Override
public void render() {

    Gdx.gl.glClearColor(1,1,1,1);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

    if(currentScreen==GameScreen.MENU_SCREEN){

        //render objects for Menu Screen

    }else if(currentScreen==GameScreen.GAME_SCREEN){

        //render objects for Game Screen
    }
}