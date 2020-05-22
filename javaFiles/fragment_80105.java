@Override
public boolean touchDown(int screenX, int screenY, int pointer, int button) {

    if(currentScreen==GameScreen.MENU_SCREEN){

        //detect button of MenuScreen by bounds or any other way
        if(check in bound){
            currentScreen==GameScreen.GAME_SCREEN;
        }

    }else if(currentScreen==GameScreen.GAME_SCREEN){

        // for Game Screen
    }
    return false;
}