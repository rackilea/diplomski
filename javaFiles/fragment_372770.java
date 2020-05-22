private int player1Pointer = -1, player2Pointer = -1;
private int player1X, player1Y, player2X, player2Y;

//...

public boolean touchDown(int screenX, int screenY, int pointer, int button){

    // Assuming top and bottom halves of screen:
    if (screenY > Gdx.graphics.getHeight() / 2){ // player 1 side
        if (player1Pointer >= 0) // player 1 already touching somewhere
            return false;
        player1Pointer = pointer;
        player1X = screenX;
        player1Y = screenY;
    } else { //player 2 side
        if (player2Pointer >= 0) // player 2 already touching somewhere
            return false;
        player2Pointer = pointer;
        player2X = screenX;
        player2Y = screenY;
    }
    return true;
}

public boolean touchDragged (int screenX, int screenY, int pointer) {
    if (pointer == player1Pointer){
        player1X = screenX;
        player1Y = screenY;
        return true;
    }
    if (pointer == player2Pointer){
        player2X = screenX;
        player2Y = screenY;
        return true;
    }
    return false;
}

public boolean touchUp (int screenX, int screenY, int pointer, int button) {
    if (pointer == player1Pointer){
        player1Pointer = -1;
        return true;
    }
    if (pointer == player2Pointer){
        player2Pointer = -1;
        return true;
    }
    return false;
}